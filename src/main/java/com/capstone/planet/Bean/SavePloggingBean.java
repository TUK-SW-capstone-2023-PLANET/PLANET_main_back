package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateMultipartFileBean;
import com.capstone.planet.Bean.Small.CreatePloggingDAOBean;
import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.SavePloggingDAOBean;
import com.capstone.planet.Model.DAO.PloggingDAO;
import com.capstone.planet.Model.DTO.ImageDTO;
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

    @Autowired
    public SavePloggingBean(CreateUniqueIdBean createUniqueIdBean, CreatePloggingDAOBean createPloggingDAOBean, SavePloggingDAOBean savePloggingDAOBean, CreateMultipartFileBean createMultipartFileBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPloggingDAOBean = createPloggingDAOBean;
        this.savePloggingDAOBean = savePloggingDAOBean;
        this.createMultipartFileBean = createMultipartFileBean;
    }

    // 플로깅 저장
    public Long exec(RequestPloggingSaveDTO requestPloggingSaveDTO) throws IOException {

        List<LocationDTO> location = requestPloggingSaveDTO.getLocation();
        int size = location.size();
        Double latitude = location.get(size / 2).getLatitude(); // 위도
        Double longitude = location.get(size / 2).getLongitude(); // 경도

        System.out.println("longitude = " + longitude); // 경도
        System.out.println("latitude = " + latitude); // 위도
        // 위도 경도를 통해 이미지 url 가져오기
        String imageUrl = createMultipartFileBean.exec(longitude, latitude).getImageUrl();

        // 플로깅 DAO 생성
        PloggingDAO ploggingDAO = createPloggingDAOBean.exec(imageUrl, requestPloggingSaveDTO);

        // 플로깅 저장
        savePloggingDAOBean.exec(ploggingDAO);

        return requestPloggingSaveDTO.getPloggingId();
    }
}
