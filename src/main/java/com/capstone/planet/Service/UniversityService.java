package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetUniversityTop3Bean;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityService {

    GetUniversityTop3Bean getUniversityTop3Bean;

    @Autowired
    public UniversityService(GetUniversityTop3Bean getUniversityTop3Bean) {
        this.getUniversityTop3Bean = getUniversityTop3Bean;
    }

    public List<ResponseUniversityGetDTO> getUniversityTop3(){
        return getUniversityTop3Bean.exec();
    }
}
