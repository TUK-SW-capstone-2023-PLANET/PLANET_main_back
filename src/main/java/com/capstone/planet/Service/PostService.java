package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetPostBean;
import com.capstone.planet.Bean.SavePostBean;
import com.capstone.planet.Model.DTO.RequestPostSaveDTO;
import com.capstone.planet.Model.DTO.ResponsePostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    GetPostBean getPostBean;
    SavePostBean savePostBean;

    @Autowired
    public PostService(GetPostBean getPostBean, SavePostBean savePostBean) {
        this.getPostBean = getPostBean;
        this.savePostBean = savePostBean;
    }

    // 게시물 가져오기
    public ResponsePostGetDTO getPost(Long postId, Long userId) {
        return getPostBean.exec(postId, userId);
    }

    // 게시물 저장
    public Long savePost(RequestPostSaveDTO requestPostSaveDTO) {
        return savePostBean.exec(requestPostSaveDTO);
    }
}
