package com.argus.ecommerce.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JValid {
    private static final String REGEX_MAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public static boolean valid(Object obj) {
        return obj == null ? false : true;
    }

    public static boolean valid(String p_str) {
        if (p_str != null && p_str.length() > 0) {
            return true;
        }
        return false;
    }

    public static boolean isNegative(Integer value) {
        return (value < 0) ? true : false;
    }

    public static boolean isPositive(Integer value) {
        return !isNegative(value);
    }

    public static boolean mailIsValid(String input) {
        Pattern pattern = Pattern.compile(REGEX_MAIL);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}