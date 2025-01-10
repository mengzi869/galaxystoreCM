package com.clean888.overseas.topon;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;

/**
 * @Class: GsonUtils
 * @Date: 2023/2/7
 * @Description:
 */
public class GsonUtils {
    private static GsonUtils instance = null;

    private static Gson gson;

    private GsonUtils() {
        gson = new Gson();
    }

    public static GsonUtils get() {
        if (instance == null) {
            instance = new GsonUtils();
        }
        return instance;
    }

    public <T> T fromJson(String str, Type type) {
        try {
            return gson.fromJson(str, type);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public <T> T fromJson(String str, Class<T> cls) {
        try {
            return gson.fromJson(str, cls);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    public String toJson(Object obj) {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public <T> T GsonToBean(Object obj, Class<T> cls) {
        if (gson != null) {
            try {
                return gson.fromJson(gson.toJson(obj), cls);
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
