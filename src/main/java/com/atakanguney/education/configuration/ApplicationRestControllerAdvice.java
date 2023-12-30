package com.atakanguney.education.configuration;

import com.atakanguney.education.exception.BaseBusinessException;
import com.atakanguney.education.exception.BusinessException;
import com.atakanguney.education.exception.ErrorResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationRestControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleMyAppException(BaseBusinessException ex) throws JsonProcessingException {
        ErrorResponse errorResponse = ex.toErrorResponse();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(errorResponse);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
    }

}
