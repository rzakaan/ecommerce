package com.argus.ecommerce.util;

import java.lang.reflect.Field;

public class JUtil {
    public static void copyValue(Object from, Object to) {
        Field[] fromFields = from.getClass().getDeclaredFields();
        for (Field fromField : fromFields) {
            try {
                // check field is exists in to object
                Field toField = to.getClass().getDeclaredField(fromField.getName());

                // get value from object
                fromField.setAccessible(true);
                Object value = fromField.get(from);

                // copy paste value
                toField.setAccessible(true);
                toField.set(to, value);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}