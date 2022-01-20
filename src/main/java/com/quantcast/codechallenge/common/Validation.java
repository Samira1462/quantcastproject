package com.quantcast.codechallenge.common;

import com.quantcast.codechallenge.config.AppConfig;
import com.quantcast.codechallenge.exception.FileNotExistException;
import com.quantcast.codechallenge.exception.InvalidArgsException;
import com.quantcast.codechallenge.exception.InvalidDateFormatException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class Validation {
   private static final Logger log = Logger.getLogger(Validation.class.getName());

    private Validation() {
    }

    public static boolean validate(String filePath, String date){
        if(!Files.exists(Paths.get(filePath))) {
             log.info("File = " + filePath + " does not exist");
            throw new FileNotExistException();
        }
        if(!isValid(date)){
            log.info("date = " + date + " is invalid");
            throw new InvalidDateFormatException();
        }
        return true;
    }

    public static boolean isValid(String date){
        boolean valid = true;
        if(!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            valid = false;
        }
        return valid;
    }

    public static boolean validateArgs(String[] args){
        if(args == null || args.length == 0 || args.length >= 6) {
            log.info(AppConfig.getProperty("validation.args"));
            throw new InvalidArgsException();
        }
        return true;
    }
}
