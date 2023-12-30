package com.atakanguney.education.exception.enums;

import com.atakanguney.education.exception.BaseBusinessException;
import com.atakanguney.education.exception.ErrorResponse;

public enum AuthenticationExceptions implements BaseBusinessException {

    INVALID_PASSWORD("AE-01", "Password is not strong enough!", "Please use 1 Digit, 1 Uppercase, 1 Lowercase, 1 special character, 8-20 characters"),
    INVALID_EMAIL("AE-02", "Email is not valid!", "");


    private final String errorCode;
    private final String errorMessage;
    private final String errorDetail;

    AuthenticationExceptions(String errorCode, String errorMessage, String errorDetail){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

    @Override
    public ErrorResponse toErrorResponse() {
        return new ErrorResponse(errorCode,errorMessage,errorDetail);
    }
}
