package com.quantcast.codechallange.exception;

public class InvalidDateFormatException extends BaseException{

    public InvalidDateFormatException() {
        putErrorArg("InvalidDateFormatException", "INVALID_DATE_FORMAT_EXCEPTION");
    }

    @Override
    public String getErrorCode() {
        return ResultCodes.INVALID_DATE_FORMAT_EXCEPTION;
    }
}
