package com.capstone.planet.Mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StringToListMapper {

    ObjectMapper objectMapper;

    @Autowired
    public StringToListMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<String> exec(String object) {
        try {
            return objectMapper.readValue(object, new TypeReference<List<String>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
