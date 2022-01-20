package com.quantcast.codechallenge.exception;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseException extends RuntimeException {
    protected Map<String, String> args;

    abstract public String getErrorCode();

    protected void putErrorArg(String key, String arg) {
        if (args == null) {
            args = new LinkedHashMap<>();
        }
        key = key.replace(".", "_");
        args.put(key, arg);
    }

    public Map<String, String> getArgs() {
        return args;
    }
}
