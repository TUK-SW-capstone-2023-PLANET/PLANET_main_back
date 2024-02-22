package com.capstone.planet.Service;

import com.capstone.planet.Bean.SaveImageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    SaveImageBean saveImageBean;

    @Autowired
    public ImageService(SaveImageBean saveImageBean) {
        this.saveImageBean = saveImageBean;
    }

    // 이미지 저장
    public String saveImage(MultipartFile file) throws IOException {
        return saveImageBean.exec(file);
    }
}
