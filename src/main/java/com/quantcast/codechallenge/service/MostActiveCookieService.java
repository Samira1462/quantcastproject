package com.quantcast.codechallenge.service;

import com.quantcast.codechallenge.model.Cookie;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MostActiveCookieService {

    private static final Logger log = Logger.getLogger(MostActiveCookieService.class.getName());

    public String getMostActiveCookiePerDate(List<Cookie> cookieList, String date) {
        final Map<String, Integer> filteredMap = CreateCookieCounterMap(cookieList, date);

        if (MapUtils.isEmpty(filteredMap)) {
            log.info("Not Cookies Find In Specific Date");
            return "Not Cookies Find In Specific Date";
        } else {
            final Optional<Map.Entry<String, Integer>> mostActiveCookie = filteredMap.entrySet().stream().max(Map.Entry.comparingByValue());
            assert (mostActiveCookie.isPresent());
            log.info(mostActiveCookie.get().getKey());
            return mostActiveCookie.get().getKey();
        }
    }

    private Map<String,Integer> CreateCookieCounterMap(List<Cookie> cookieList, final String target) {
        Map<String,Integer> filteredMap = new HashMap<>();
        cookieList.stream()
                .filter(x -> x.getTimeStamp().equals(target))
                .collect(Collectors.toList())
                .forEach(x -> {
                            if (!filteredMap.containsKey(x.getCookieName()))
                                filteredMap.put(x.getCookieName(), 1);
                            else
                                filteredMap.put(x.getCookieName(), filteredMap.get(x.getCookieName()) + 1);
                        }
                );
        return filteredMap;
    }
}
