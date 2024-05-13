package com.capstone.planet.Service;

import com.capstone.planet.Bean.SavePostBean;
import com.capstone.planet.Model.DTO.RequestPostSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    SavePostBean savePostBean;

    @Autowired
    public PostService(SavePostBean savePostBean) {
        this.savePostBean = savePostBean;
    }

    // 게시물 저장
    public Long savePost(RequestPostSaveDTO requestPostSaveDTO) {
        return savePostBean.exec(requestPostSaveDTO);
    }
}
