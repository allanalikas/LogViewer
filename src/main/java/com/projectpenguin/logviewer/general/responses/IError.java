package com.projectpenguin.logviewer.general.responses;

import com.projectpenguin.logviewer.general.errors.ErrorCode;

public interface IError {
    ErrorCode getErrorCode();

    String getErrorMessage();
}
