package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.SaveImageS3Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class SaveImageBean {

    SaveImageS3Bean saveImageS3Bean;

    @Autowired
    public SaveImageBean(SaveImageS3Bean saveImageS3Bean) {
        this.saveImageS3Bean = saveImageS3Bean;
    }

    // 이미지 저장
    public String exec(MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            return "";
        }

        // 이미지 저장
        // List<String> imageUrls = saveImagesS3Bean.exec(files.get(0));
        String imageUrls = saveImageS3Bean.exec(file);

        // 이미지 DAO 생성
        //ImageDAO imageDAO = createImageDAOBean.exec(file, imageUrls);

        // 이미지 DAO 저장
        //saveImageDAOBean.exec(imageDAO);

        // 이미지 Url 반환
        return imageUrls;
    }
}
