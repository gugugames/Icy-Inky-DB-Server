package com.bridge.icyinky.api;

import com.bridge.icyinky.dto.DefaultRes;
import com.bridge.icyinky.model.LoginReq;
import com.bridge.icyinky.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RequestMapping("login")
@RestController
public class LoginController {

    private final AuthService authService;
    public LoginController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("")
    public ResponseEntity login(@RequestBody @Valid final LoginReq loginReq) throws Exception {
        DefaultRes loginRes = authService.login(loginReq);

        if(loginRes == null)
            throw new Exception();

        return new ResponseEntity<>(loginRes, HttpStatus.OK);
    }
}
