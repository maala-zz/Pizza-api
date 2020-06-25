package com.innoscripta.pizza.controller;

import com.innoscripta.pizza.dto.*;
import com.innoscripta.pizza.repository.UserRepository;
import com.innoscripta.pizza.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity<SignupResponseDto> signUp(@RequestBody SignupDto signUpDto) {
        ResponseEntity<SignupResponseDto> result = userService.signup(signUpDto);// authorizationService.signup(signUpDto);
        return result;
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public ResponseEntity<?> signIn(HttpServletRequest req, @RequestBody SignInRequestDto signInRequestDto) {
        ResponseEntity<?> result = userService.signin(signInRequestDto);
        return result;
    }

    /*
    @RequestMapping(value = "/test-token", method = RequestMethod.POST)
    @ApiOperation(value = "", authorizations = { @Authorization(value="jwtToken") })
    public ResponseEntity<?> test(HttpServletRequest req, @RequestBody SignInRequestDto signUpDto) {
        String x = userService.fetchTokenClaims(req);
        return null;
    }
    */
}
