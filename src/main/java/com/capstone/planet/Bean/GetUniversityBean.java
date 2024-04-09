package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.GetUniversityDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseUniversityGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUniversityBean {

    GetUserDAOBean getUserDAOBean;
    GetUniversityDAOBean getUniversityDAOBean;

    @Autowired
    public GetUniversityBean(GetUserDAOBean getUserDAOBean, GetUniversityDAOBean getUniversityDAOBean) {
        this.getUserDAOBean = getUserDAOBean;
        this.getUniversityDAOBean = getUniversityDAOBean;
    }

    public ResponseUniversityGetDTO exec(Long userId){

        UserDAO userDAO = getUserDAOBean.exec(userId);
        if (userDAO == null) return null;
        String universityName = userDAO.getUniversityName();

        UniversityDAO universityDAO = getUniversityDAOBean.exec(universityName);
        if (universityDAO == null) return null;


        List<UniversityDAO> universityDAOS = getUniversityDAOBean.exec(userId);

        int i = 1; // 인덱스 초기화
        for (UniversityDAO dao : universityDAOS) {
            if (dao.equals(universityDAO)) {
                // 일치하는 객체를 찾으면 해당 인덱스로 반환
                ResponseUniversityGetDTO responseUniversityGetDTO = new ResponseUniversityGetDTO();

                responseUniversityGetDTO.setName(universityDAO.getName());
                responseUniversityGetDTO.setImageUrl(universityDAO.getImageUrl());
                responseUniversityGetDTO.setScore(universityDAO.getScore());
                responseUniversityGetDTO.setRank(i);
                return responseUniversityGetDTO;
            }
            i++; // 일치하지 않으면 인덱스 증가
        }

        return null;
    }
}
