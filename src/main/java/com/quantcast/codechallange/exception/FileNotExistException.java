package com.quantcast.codechallange.exception;

public class FileNotExistException extends BaseException{

    public FileNotExistException() {
            putErrorArg("FileNotExistException", "FILE_NOT_EXIST_EXCEPTION");
        }

    @Override
    public String getErrorCode() {
        return ResultCodes.FILE_NOT_EXIST_EXCEPTION;
    }
}
