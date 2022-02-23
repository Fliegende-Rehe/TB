package ru.telegram.parser;

import java.io.*;

public class Properties {

    public static final class Property {
        private final String token;
        private final String username;

        public Property(String first, String second) {
            this.token = first;
            this.username = second;
        }

        public String getToken() { return token; }
        public String getUsername() { return username; }
    }

    public static Property Get(String PATH){
        try {
            FileInputStream fis;
            java.util.Properties property = new java.util.Properties();
            fis = new FileInputStream(PATH);
            property.load(fis);
            return new Property(property.getProperty("token"), property.getProperty("username"));
        } catch (Exception e) { e.printStackTrace();}
        return null;
    }
}
