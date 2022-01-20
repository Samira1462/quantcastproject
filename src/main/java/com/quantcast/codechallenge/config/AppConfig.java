package com.quantcast.codechallenge.config;

import com.quantcast.codechallenge.exception.AppProcessingException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class AppConfig {

    private static final String APP_PROPERTy_FILE_KEY = "app.property.file.location";
    private String resourceName = System.getProperty(APP_PROPERTy_FILE_KEY,"app.properties");

    private Properties properties;

    private AppConfig() {

    }

    private static AppConfig appConfig;

    private void init() throws AppProcessingException {
        properties = new Properties();
        try (InputStream resourceStream = getClass().getClassLoader().
                getResourceAsStream(resourceName)) {
            properties.load(resourceStream);
        } catch (IOException e) {
            throw new AppProcessingException();
        }
    }

    public static String getProperty(String key) throws AppProcessingException {
        if (appConfig == null) {
            appConfig = new AppConfig();
            appConfig.init();
        }
        return appConfig.properties.getProperty(key);
    }
}