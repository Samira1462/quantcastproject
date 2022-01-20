package com.quantcast.codechallenge.controller;

import com.quantcast.codechallenge.model.Cookie;
import com.quantcast.codechallenge.service.MostActiveCookieService;
import com.quantcast.codechallenge.service.ReadFileService;

import java.util.List;
import java.util.logging.Logger;

public class ProcessController {

    private static final Logger log = Logger.getLogger(ProcessController.class.getName());

    public void findMostActiveCookie(String filePath, String date) {
        log.info("<----------------------process start--------------->");
        ReadFileService readFileService = new ReadFileService();
        List<Cookie> cookieList = readFileService.createCookieListFromFile(filePath);
        log.info("<-------------find Most Active cookie-------------->");
        MostActiveCookieService mostActiveCookieService = new MostActiveCookieService();
        mostActiveCookieService.getMostActiveCookiePerDate(cookieList, date);
    }
}
