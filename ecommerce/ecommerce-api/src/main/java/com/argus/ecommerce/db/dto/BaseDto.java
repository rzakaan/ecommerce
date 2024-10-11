package com.argus.ecommerce.db.dto;

import java.lang.reflect.Field;

public abstract class BaseDto {
    public void copyValuesFrom(Object obj) {
        Field[] fields = getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Class objClass = obj.getClass();
                Field f = objClass.getDeclaredField(field.getName());
                f.setAccessible(true);
                Object value = f.get(obj);

                field.setAccessible(true);
                field.set(this, value);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}