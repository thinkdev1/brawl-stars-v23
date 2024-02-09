package com.nosteam.nostbrawl.Utils;

import java.util.Random;

public class Helpers {
    public Helpers() {
        ;
    }
    public String randomToken() {
        int length = 10;
        Random r = new Random();
        String s = r.ints(48, 122)
                    .filter(i -> (i < 57 || i > 65) && (i < 90 || i > 97))
                    .mapToObj(i -> (char) i)
                    .limit(length)
                    .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                    .toString();
        return s;
    }
}