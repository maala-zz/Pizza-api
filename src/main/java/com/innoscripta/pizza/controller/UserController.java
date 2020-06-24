package com.innoscripta.pizza.controller;

import com.innoscripta.pizza.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity<Boolean> signUp(@RequestBody SignupDto signUpDto) {
        ResponseEntity<Boolean> result = null;// authorizationService.signup(signUpDto);
        return result;
    }

    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public ResponseEntity<Boolean> signIn(@RequestBody SignInRequestDto signUpDto) {
        ResponseEntity<Boolean> result = null;// authorizationService.signup(signUpDto);
        return result;
    }
}
