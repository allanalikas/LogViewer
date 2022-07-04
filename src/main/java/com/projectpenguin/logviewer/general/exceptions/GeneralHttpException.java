package com.projectpenguin.logviewer.general.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.projectpenguin.logviewer.general.errors.ErrorCode;
import com.projectpenguin.logviewer.general.responses.GeneralResponse;

public class GeneralHttpException extends Exception {
    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String message;

    public GeneralHttpException( ErrorCode errorCode, String message ) {
        this(HttpStatus.OK, errorCode, message);
    }

    public GeneralHttpException(HttpStatus httpStatus, ErrorCode errorCode, String message ) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

    public ResponseEntity createErrorResponse() {
        GeneralResponse response = new GeneralResponse(ErrorCode.SYSTEM, "Error");
        return ResponseEntity.ok().body(response);
    }

}
