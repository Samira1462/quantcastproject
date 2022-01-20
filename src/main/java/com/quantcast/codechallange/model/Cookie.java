package com.quantcast.codechallange.model;

public class Cookie {
    private String cookieName;
    private String timeStamp;

    public Cookie(String cookieName, String timeStamp) {
        this.cookieName = cookieName;
        this.timeStamp = timeStamp;
    }

    public Cookie() {
    }

    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
