package com.atakanguney.education.exception.enums;

import com.atakanguney.education.exception.BaseBusinessException;
import com.atakanguney.education.exception.ErrorResponse;
import lombok.Getter;

@Getter
public enum UserExceptions implements BaseBusinessException {
    USER_NOT_FOUND("UE-01", "User not found!", ""),
    USER_IS_NOT_ACTIVE("UE-02", "User is not active!", "");

    private final String errorCode;
    private final String errorMessage;
    private final String errorDetail;

    UserExceptions(String errorCode, String errorMessage, String errorDetail){
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

    @Override
    public ErrorResponse toErrorResponse() {
        return new ErrorResponse(errorCode,errorMessage,errorDetail);
    }
}
