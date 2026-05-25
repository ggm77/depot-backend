package com.seohamin.depot.global.exception.response;

import com.seohamin.depot.global.exception.constants.ExceptionCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
public class ExceptionResponse {
    private final LocalDateTime timestamp;
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public ExceptionResponse(final ExceptionCode exceptionCode) {
        this.timestamp = LocalDateTime.now();
        this.httpStatus = exceptionCode.getHttpStatus();
        this.code = exceptionCode.name();
        this.message = exceptionCode.getMessage();
    }
}
