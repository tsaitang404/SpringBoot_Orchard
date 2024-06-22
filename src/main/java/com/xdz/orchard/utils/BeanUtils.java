package com.xdz.orchard.utils;
import java.lang.reflect.Field;
import java.util.Objects;

public class BeanUtils {
    public static boolean isFieldNotNull(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        boolean flag = true;
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (Objects.nonNull(field.get(obj))){
                    System.out.println(field.get(obj));
                    flag=false;
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                field.setAccessible(false);
            }
        }
        return flag;
    }
}
