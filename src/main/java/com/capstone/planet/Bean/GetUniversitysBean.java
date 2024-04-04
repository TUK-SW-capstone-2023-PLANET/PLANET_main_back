package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniversityDTOBean;
import com.capstone.planet.Bean.Small.GetUniversityDAOBean;
import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GetUniversitysBean {

    GetUniversityDAOBean getUniversityDAOBean;
    CreateUniversityDTOBean createUniversityDTOBean;

    @Autowired
    public GetUniversitysBean(GetUniversityDAOBean getUniversityDAOBean, CreateUniversityDTOBean createUniversityDTOBean) {
        this.getUniversityDAOBean = getUniversityDAOBean;
        this.createUniversityDTOBean = createUniversityDTOBean;
    }

    // 대학교 전체 랭킹 조회
    public List<Map<Integer, ResponseUniversityGetDTO>> exec(){

        List<UniversityDAO> universityDAOS = getUniversityDAOBean.exec(null, null);

        return createUniversityDTOBean.exec(null, universityDAOS);
    }
}
