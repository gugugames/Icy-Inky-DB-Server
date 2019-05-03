package com.bridge.icyinky.mapper;

import com.bridge.icyinky.dto.User;
import com.bridge.icyinky.model.SignUpReq;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    //로그인
    @Select("SELECT * FROM USERS WHERE id = #{id} AND password = #{password}")
    User findByIdAndPassword(@Param("id") final String id, @Param("password") final String password);

    // 회원 가입
    @Insert("INSERT INTO USERS(id, password, message) VALUES(#{signUpReq.id}, #{signUpReq.password}, #{signUpReq.message})")
    @Options(useGeneratedKeys = true, keyColumn = "USERS.idx")
    void save(@Param("signUpReq") final SignUpReq signUpReq);
}

