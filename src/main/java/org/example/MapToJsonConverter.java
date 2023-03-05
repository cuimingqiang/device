package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.persistence.AttributeConverter;

import java.lang.reflect.Type;
import java.util.Map;

public class MapToJsonConverter implements AttributeConverter<Map<String, Object>, String> {
    private Gson gson = new Gson();
    private Type map = TypeToken.getParameterized(Map.class, String.class, Object.class).getType();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> stringObjectMap) {
        if (stringObjectMap == null) return null;
        return gson.toJson(stringObjectMap);
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String s) {
        if (s == null) return null;
        return gson.fromJson(s, map);
    }
}
