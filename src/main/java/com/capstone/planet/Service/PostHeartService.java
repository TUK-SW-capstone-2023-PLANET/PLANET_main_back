package com.capstone.planet.Service;

import com.capstone.planet.Bean.SavePostHeartBean;
import com.capstone.planet.Model.DTO.RequestPostHeartSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostHeartService {

    SavePostHeartBean savePostHeartBean;

    @Autowired
    public PostHeartService(SavePostHeartBean savePostHeartBean) {
        this.savePostHeartBean = savePostHeartBean;
    }

    // 게시물 좋아요 저장
    public Long savePostHeart(RequestPostHeartSaveDTO requestPostHeartSaveDTO) {
        return savePostHeartBean.exec(requestPostHeartSaveDTO);
    }
}
