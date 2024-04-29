package org.example.lab5.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.List;

public class ConvertToObject {
    public static Object convertJsonToOject(String json, Class<? extends Object> clazz) {
        return new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create().fromJson(json, clazz);
    }

    public static List<? extends Class> convertJsonToList(String json, Class<? extends Object> clazz) {
        return (List<? extends Class>) new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create().fromJson(json, clazz);
    }
}
