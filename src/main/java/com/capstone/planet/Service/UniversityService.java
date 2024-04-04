package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetUniversityTop3Bean;
import com.capstone.planet.Bean.GetUniversitysBean;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UniversityService {

    GetUniversityTop3Bean getUniversityTop3Bean;
    GetUniversitysBean getUniversitysBean;

    @Autowired
    public UniversityService(GetUniversityTop3Bean getUniversityTop3Bean, GetUniversitysBean getUniversitysBean) {
        this.getUniversityTop3Bean = getUniversityTop3Bean;
        this.getUniversitysBean = getUniversitysBean;
    }

    // 대학 탑 3 조회
    public List<ResponseUniversityGetDTO> getUniversityTop3(){
        return getUniversityTop3Bean.exec();
    }

    // 대학 랭킹 전체 조회
    public List<Map<Integer, ResponseUniversityGetDTO>> getUniversitys(){
        return getUniversitysBean.exec();
    }
}
