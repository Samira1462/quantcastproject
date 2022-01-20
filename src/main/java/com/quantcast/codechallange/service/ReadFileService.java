package com.quantcast.codechallange.service;

import com.quantcast.codechallange.model.Cookie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ReadFileService {

    private static final Logger log = Logger.getLogger(ReadFileService.class.getName());
    public static final int FIRST_INDEX = 0;
    public static final int END_INDEX = 11;

    public List<Cookie> createCookieListFromFile(String filePath) {
        List<Cookie> cookieList = new ArrayList<>();
        String line = "";

        try(FileReader fileReader = new FileReader(filePath)) {
            log.info("<-------------start reading a file--------------->");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null ){
                if (line.equals("cookie,timestamp")) {
                    continue;
                }
                Cookie cookie = new Cookie();
                int indexSeparator = line.indexOf(",");
                line.substring(indexSeparator +  1, indexSeparator + END_INDEX);
                cookie.setCookieName(line.substring(FIRST_INDEX,indexSeparator));
                cookie.setTimeStamp(line.substring(indexSeparator + 1, indexSeparator + END_INDEX));
                cookieList.add(cookie);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return cookieList;
    }

}
