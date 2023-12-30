package com.atakanguney.education.exception;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final BaseBusinessException baseBusinessException;

    public BusinessException(BaseBusinessException baseBusinessException) {
        super(baseBusinessException.toErrorResponse().getErrorMessage());
        this.baseBusinessException = baseBusinessException;
    }

}
