package com.capstone.planet.Service;

import com.capstone.planet.Bean.DeletePostHeartBean;
import com.capstone.planet.Bean.SavePostHeartBean;
import com.capstone.planet.Model.DTO.RequestPostHeartDeleteDTO;
import com.capstone.planet.Model.DTO.RequestPostHeartSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostHeartService {

    SavePostHeartBean savePostHeartBean;
    DeletePostHeartBean deletePostHeartBean;

    @Autowired
    public PostHeartService(SavePostHeartBean savePostHeartBean, DeletePostHeartBean deletePostHeartBean) {
        this.savePostHeartBean = savePostHeartBean;
        this.deletePostHeartBean = deletePostHeartBean;
    }

    // 게시물 좋아요 저장
    public Long savePostHeart(RequestPostHeartSaveDTO requestPostHeartSaveDTO) {
        return savePostHeartBean.exec(requestPostHeartSaveDTO);
    }

    // 게시물 좋아요 삭제
    public Long deletePostHeart(RequestPostHeartDeleteDTO requestPostHeartDeleteDTO) {
        return deletePostHeartBean.exec(requestPostHeartDeleteDTO);
    }
}
