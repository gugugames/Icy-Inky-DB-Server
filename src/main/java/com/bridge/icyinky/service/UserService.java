package com.bridge.icyinky.service;
import com.bridge.icyinky.dto.DefaultRes;
import com.bridge.icyinky.model.SignUpReq;

public interface UserService {
    DefaultRes saveUser(final SignUpReq signUpReq);
}
