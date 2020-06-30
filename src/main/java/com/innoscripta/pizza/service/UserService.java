package com.innoscripta.pizza.service;

import com.innoscripta.pizza.dto.JwtResponseDto;
import com.innoscripta.pizza.dto.SignInRequestDto;
import com.innoscripta.pizza.dto.SignupDto;
import com.innoscripta.pizza.dto.SignupResponseDto;
import com.innoscripta.pizza.entity.User;
import com.innoscripta.pizza.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService implements UserDetailsService {

    //region Properties
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //endregion

    //region Methods
    public ResponseEntity<SignupResponseDto> signup(SignupDto signupDto) {
        try {
            User previousUsrWithTheSameEmail = loadUserByEmail(signupDto.email);
            if (previousUsrWithTheSameEmail != null) {
                return new ResponseEntity<SignupResponseDto>(HttpStatus.ALREADY_REPORTED);
            }
            User mappedUser = new User(signupDto.email, signupDto.address, signupDto.password, signupDto.telephone, signupDto.name);
            User user = userRepository.save(mappedUser);
            if (user == null)
                return new ResponseEntity<SignupResponseDto>(HttpStatus.INTERNAL_SERVER_ERROR);
            SignupResponseDto result = new SignupResponseDto(user.id);
            return new ResponseEntity<SignupResponseDto>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<SignupResponseDto>(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    public ResponseEntity<?> signin(SignInRequestDto authenticationRequest) {
        try {
            //         Authentication result = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.userEmail, authenticationRequest.password));
            final User userDetails = loadUserByEmailAndPassword(authenticationRequest.userEmail, authenticationRequest.password);
            final String token = jwtTokenUtil.generateToken(userDetails);
            return ResponseEntity.ok(new JwtResponseDto(token));
        } catch (DisabledException e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.FAILED_DEPENDENCY);
        } catch (BadCredentialsException e) {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    public User loadUserById(UUID userId) throws UsernameNotFoundException {
        User user = userRepository.findUserById(userId);
        if (user != null)
            return user;
        throw new UsernameNotFoundException("User not found with username: " + userId);
    }

    public User loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user != null)
            return user;
        return null;
    }

    public User loadUserByEmailAndPassword(String email, String password) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmailAndPassword(email, password);
        if (user != null)
            return user;
        throw new UsernameNotFoundException("User not found with ID: " + email);
    }
    //endregion
}
