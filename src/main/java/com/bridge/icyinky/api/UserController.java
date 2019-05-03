package com.bridge.icyinky.api;

import com.bridge.icyinky.dto.DefaultRes;
import com.bridge.icyinky.model.SignUpReq;
import com.bridge.icyinky.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("users")
@RestController
public class UserController {
    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public ResponseEntity signUp(SignUpReq signUpReq) throws Exception {
        DefaultRes signUpRes = userService.saveUser(signUpReq);

        if(signUpRes == null)
            throw new Exception();

        return new ResponseEntity<>(signUpRes, HttpStatus.OK);
    }

}