package com.quantcast.codechallange.exception;

public class InvalidArgsException extends BaseException {

    public InvalidArgsException() {
        putErrorArg("InvalidArgsException", "INVALID_ARGS_EXCEPTION");
    }

    @Override
    public String getErrorCode() {
        return ResultCodes.INVALID_ARGS_EXCEPTION;
    }
}
