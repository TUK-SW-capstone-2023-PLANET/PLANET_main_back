package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DTO.LocationDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPloggingLocationDAOBean {

    public List<LocationDTO> exec(String location){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(location, new TypeReference<List<LocationDTO>>(){});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
