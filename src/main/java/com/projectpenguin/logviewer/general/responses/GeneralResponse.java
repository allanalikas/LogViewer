package com.projectpenguin.logviewer.general.responses;

import com.projectpenguin.logviewer.general.errors.ErrorCode;

public class GeneralResponse extends AbstractResponse {

    private ErrorCode errorCode;
    private String message;

    public GeneralResponse(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public ErrorCode getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.message;
    }
}
