package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateImageDAOBean;
import com.capstone.planet.Bean.Small.SaveImageDAOBean;
import com.capstone.planet.Bean.Small.SaveImageS3Bean;
import com.capstone.planet.Model.DAO.ImageDAO;
import com.capstone.planet.Model.DTO.ImageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class SaveImageBean {

    SaveImageS3Bean saveImageS3Bean;
    CreateImageDAOBean createImageDAOBean;
    SaveImageDAOBean saveImageDAOBean;

    @Autowired
    public SaveImageBean(SaveImageS3Bean saveImageS3Bean, CreateImageDAOBean createImageDAOBean, SaveImageDAOBean saveImageDAOBean) {
        this.saveImageS3Bean = saveImageS3Bean;
        this.createImageDAOBean = createImageDAOBean;
        this.saveImageDAOBean = saveImageDAOBean;
    }

    // 이미지 저장
    public ImageDTO exec(MultipartFile file) throws IOException {

        if (file == null || file.isEmpty()) {
            return null;
        }

        // 이미지 저장
        // List<String> imageUrls = saveImagesS3Bean.exec(files.get(0));
        String imageUrls = saveImageS3Bean.exec(file);

        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setImageUrl(imageUrls);

        // 이미지 DAO 생성
        ImageDAO imageDAO = createImageDAOBean.exec(file, imageUrls);

        // 이미지 DAO 저장
        saveImageDAOBean.exec(imageDAO);

        // 이미지 Url 반환
        return imageDTO;
    }
}
