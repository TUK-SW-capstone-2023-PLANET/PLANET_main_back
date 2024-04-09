package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniversityDTOBean;
import com.capstone.planet.Bean.Small.GetUniversityDAOBean;
import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ResponseUniversityGetDTO> exec(Pageable pageable){

        Page<UniversityDAO> universityDAOS = getUniversityDAOBean.exec(pageable);

        return createUniversityDTOBean.exec(null, universityDAOS);
    }
}
