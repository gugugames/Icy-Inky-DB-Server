package com.bridge.icyinky.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by bomi on 2018-12-28.
 */

@Data
public class SignUpReq {
    private String id; // id
    private String password; // password
    private String message;
}
