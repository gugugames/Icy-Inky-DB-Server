package com.bridge.icyinky.service.impl;

import com.bridge.icyinky.dto.DefaultRes;
import com.bridge.icyinky.dto.User;
import com.bridge.icyinky.mapper.UserMapper;
import com.bridge.icyinky.model.LoginReq;
import com.bridge.icyinky.service.AuthService;
import com.bridge.icyinky.utils.Message;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserMapper userMapper;

    public AuthServiceImpl(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public DefaultRes login(final LoginReq loginReq) {
        final User user = userMapper.findByIdAndPassword(loginReq.getId(), loginReq.getPassword());

        if (user != null) {
            return DefaultRes.res(HttpStatus.OK.value(), Message.LOGIN_SUCCESS);
        }

        return DefaultRes.res(HttpStatus.NO_CONTENT.value(), Message.NOT_FOUND_ID);
    }


}
