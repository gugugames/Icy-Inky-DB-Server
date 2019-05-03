package com.bridge.icyinky.service.impl;

import com.bridge.icyinky.dto.DefaultRes;
import com.bridge.icyinky.dto.User;
import com.bridge.icyinky.mapper.UserMapper;
import com.bridge.icyinky.model.SignUpReq;
import com.bridge.icyinky.service.UserService;
import com.bridge.icyinky.utils.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Transactional
    @Override
    public DefaultRes saveUser(final SignUpReq signUpReq) {
        try {
            userMapper.save(signUpReq);

            return DefaultRes.res(HttpStatus.CREATED.value(), Message.SIGNUP_SUCCESS);
        } catch(Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            log.error(e.getMessage());
            return DefaultRes.res(600, Message.DB_ERROR);
        }
    }

}
