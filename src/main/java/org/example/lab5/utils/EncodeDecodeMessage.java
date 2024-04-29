package org.example.lab5.utils;

import java.util.Base64;

public class EncodeDecodeMessage {

    public static String encodeMessage(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

    public static String decodeMessage(String message) {
        return new String(Base64.getDecoder().decode(message));
    }
}
