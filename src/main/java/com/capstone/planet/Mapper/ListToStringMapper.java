package com.capstone.planet.Mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListToStringMapper {

    ObjectMapper objectMapper;

    @Autowired
    public ListToStringMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String exec(List<String> object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
