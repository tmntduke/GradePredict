package Util;

import com.google.gson.GsonBuilder;

public class GsonUtil {
    public static Object json2object(String s, Class<?> clz) {
        Object o = new GsonBuilder().disableHtmlEscaping()
                .create()
                .fromJson(s, clz);

        return o;
    }

    public static String object2json(Object o) {
        String s = new GsonBuilder().disableHtmlEscaping().create()
                .toJson(o);
        return s;
    }
}
