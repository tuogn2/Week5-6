package org.example.lab5.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConvertToJson {

    public static String convertObjectToJson(Object object) {
        return new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create().toJson(object);
    }

    public static String convertListToJson(List<Object> list) {
        return new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter()).create().toJson(list);
    }
}
