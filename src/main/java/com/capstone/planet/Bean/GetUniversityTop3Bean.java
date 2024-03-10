package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniversityDTOBean;
import com.capstone.planet.Bean.Small.GetUniversityDAOBean;
import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUniversityTop3Bean {

    GetUniversityDAOBean getUniversityDAOBean;
    CreateUniversityDTOBean createUniversityDTOBean;

    @Autowired
    public GetUniversityTop3Bean(GetUniversityDAOBean getUniversityDAOBean, CreateUniversityDTOBean createUniversityDTOBean) {
        this.getUniversityDAOBean = getUniversityDAOBean;
        this.createUniversityDTOBean = createUniversityDTOBean;
    }

    // 점수 높은 대학 3개 조회
    public List<ResponseUniversityGetDTO> exec(){

        List<UniversityDAO> universityDAOS = getUniversityDAOBean.exec();

        return createUniversityDTOBean.exec(universityDAOS);
    }
}
