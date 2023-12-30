package com.atakanguney.education.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private final String errorCode;
    private final String errorMessage;
    private final String errorDetail;

    public ErrorResponse(String errorCode, String errorMessage, String errorDetail) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

}
