package com.bridge.icyinky.utils;

public enum ErrorCode {

    REQUEST_NO_RESULT(204, Message.NO_REQUEST),
    NO_SIGNED_UP_INFO(2041, Message.NOT_FOUND_ID),
    WRONG_REQUEST(400, Message.BAD_REQUEST),
    NOT_FOUND(404, Message.NOT_FOUND),
    SERVER_SYSTEM_ERROR(500, Message.INTERNAL_SERVER_ERROR),
    SERVER_DB_ERROR(600, Message.DB_ERROR);

    private int statusCode;
    private String stringResource;

    ErrorCode(int statusCode, String stringResource) {
        this.statusCode = statusCode;
        this.stringResource = stringResource;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStringResource() {
        return stringResource;
    }

    public static ErrorCode convertToErrorCode(int statusCode) {
        for(ErrorCode errorCode : ErrorCode.values()) {
            if(statusCode == errorCode.getStatusCode()) {
                return errorCode;
            }
        }
        return null;
    }
}