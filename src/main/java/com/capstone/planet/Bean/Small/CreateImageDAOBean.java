package com.capstone.planet.Bean.Small;

import com.capstone.planet.Model.DAO.ImageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class CreateImageDAOBean {

    CreateUniqueIdBean createUniqueIdBean;

    @Autowired
    public CreateImageDAOBean(CreateUniqueIdBean createUniqueIdBean) {
        this.createUniqueIdBean = createUniqueIdBean;
    }

    // 이미지 생성시 DAO 저장
    public ImageDAO exec(MultipartFile file, String imageUrl) throws IOException {

        // 이미지 아이디
        Long imageId = createUniqueIdBean.exec();

        // 이미지 이름
        String imageName = file.getOriginalFilename();

        // 업로드 시간
        LocalDateTime uploadTime = LocalDateTime.now().plusHours(9);

        // 이미지 DAO 리턴
        return new ImageDAO(imageId, imageName, imageUrl, uploadTime);

    }
}
