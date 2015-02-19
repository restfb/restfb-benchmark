package com.restfb;

import com.restfb.util.StringUtils;

import java.io.IOException;

public class JsonMapper {
    static String jsonFromClasspath(String pathToJson) {
        try {
            return StringUtils.fromInputStream(JsonMapper.class.getResourceAsStream("/json/" + pathToJson + ".json"));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to load JSON from the classpath", e);
        }
    }
}