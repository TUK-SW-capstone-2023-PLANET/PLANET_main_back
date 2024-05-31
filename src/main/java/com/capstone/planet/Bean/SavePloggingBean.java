package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.*;
import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DAO.SeasonDAO;
import com.capstone.planet.Model.DAO.UniversityDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.LocationDTO;
import com.capstone.planet.Model.DTO.RequestPloggingSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class SavePloggingBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePloggingDAOBean createPloggingDAOBean;
    SavePloggingDAOBean savePloggingDAOBean;
    CreateMultipartFileBean createMultipartFileBean;
    GetUserDAOBean getUserDAOBean;
    GetUniversityDAOBean getUniversityDAOBean;
    GetSeasonUserDAOBean getSeasonUserDAOBean;
    SaveUserDAOBean saveUserDAOBean;
    SaveUniversityDAOBean saveUniversityDAOBean;
    SaveSeasonDAOBean saveSeasonDAOBean;
    GetAddressBean getAddressBean;


    @Autowired
    public SavePloggingBean(GetAddressBean getAddressBean, CreateUniqueIdBean createUniqueIdBean, CreatePloggingDAOBean createPloggingDAOBean, SavePloggingDAOBean savePloggingDAOBean, CreateMultipartFileBean createMultipartFileBean, GetUserDAOBean getUserDAOBean, GetUniversityDAOBean getUniversityDAOBean, GetSeasonUserDAOBean getSeasonUserDAOBean, SaveUserDAOBean saveUserDAOBean, SaveUniversityDAOBean saveUniversityDAOBean, SaveSeasonDAOBean saveSeasonDAOBean) {
        this.getAddressBean = getAddressBean;
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPloggingDAOBean = createPloggingDAOBean;
        this.savePloggingDAOBean = savePloggingDAOBean;
        this.createMultipartFileBean = createMultipartFileBean;
        this.getUserDAOBean = getUserDAOBean;
        this.getUniversityDAOBean = getUniversityDAOBean;
        this.getSeasonUserDAOBean = getSeasonUserDAOBean;
        this.saveUserDAOBean = saveUserDAOBean;
        this.saveUniversityDAOBean = saveUniversityDAOBean;
        this.saveSeasonDAOBean = saveSeasonDAOBean;
    }

    // 플로깅 저장
    public Long exec(RequestPloggingSaveDTO requestPloggingSaveDTO) throws IOException {

        List<LocationDTO> location = requestPloggingSaveDTO.getLocation();
        int size = location.size();
        Double latitude = location.get(size / 2).getLatitude(); // 위도
        Double longitude = location.get(size / 2).getLongitude(); // 경도

        // 위도 경도를 통해 이미지 url 가져오기
        String imageUrl = createMultipartFileBean.exec(longitude, latitude).getImageUrl();

        String address = getAddressBean.exec(longitude, latitude);

        // 플로깅 DAO 생성
        PloggingDAO ploggingDAO = createPloggingDAOBean.exec(address, imageUrl, requestPloggingSaveDTO);

        UserDAO userDAO = getUserDAOBean.exec(requestPloggingSaveDTO.getUserId());
        if (userDAO == null) return 0L;

        // 플로깅 저장시 유저 점수 증가
        userDAO.setScore(userDAO.getScore() + ploggingDAO.getScore());

        // 플로깅 저장시 대학 점수 증가
        UniversityDAO universityDAO = getUniversityDAOBean.exec(userDAO.getUniversityName());
        if (universityDAO == null) return 0L;
        universityDAO.setScore(universityDAO.getScore() + ploggingDAO.getScore());

        // 플로깅 저장시 시즌 점수 증가
        SeasonDAO seasonDAO = getSeasonUserDAOBean.exec(userDAO.getUserId());
        if (seasonDAO == null) {
            seasonDAO = new SeasonDAO();
            seasonDAO.setSeasonId(createUniqueIdBean.exec());
            seasonDAO.setUserId(userDAO.getUserId());
            seasonDAO.setUniversityLogo(universityDAO.getImageUrl());
            seasonDAO.setUserName(userDAO.getNickName());
            seasonDAO.setScore(ploggingDAO.getScore());
        }
        seasonDAO.setScore(seasonDAO.getScore() + ploggingDAO.getScore());

        // 유저 저장
        saveUserDAOBean.exec(userDAO);

        // 플로깅 저장
        savePloggingDAOBean.exec(ploggingDAO);

        // 대학 저장
        saveUniversityDAOBean.exec(universityDAO);

        // 시즌 저장
        saveSeasonDAOBean.exec(seasonDAO);

        return requestPloggingSaveDTO.getPloggingId();
    }
}
