package com.quantcast.codechallenge.exception;

public class AppProcessingException extends BaseException{

    public AppProcessingException() {
        putErrorArg("AppProcessingException", "READ_PROPERTIES_EXCEPTION");
    }

    @Override
    public String getErrorCode() {
        return ResultCodes.READ_PROPERTIES_EXCEPTION;
    }
}
