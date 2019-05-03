package com.bridge.icyinky.service;

import com.bridge.icyinky.dto.DefaultRes;
import com.bridge.icyinky.model.LoginReq;

public interface AuthService {
     DefaultRes login(final LoginReq loginReq);
}

