package de.ite.openchat.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

    public static String toString(Object jsonObject) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(jsonObject);
    }

    public static <T> T toObject(String jsonString, Class<T> clazz) throws JsonProcessingException {
        return new ObjectMapper().readValue(jsonString, clazz);
    }
}
