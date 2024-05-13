package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.*;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.PostHeartDAO;
import com.capstone.planet.Model.DTO.RequestPostHeartSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostHeartBean {

    CreateUniqueIdBean createUniqueIdBean;
    GetPostHeartDAOBean getPostHeartDAOBean;
    CreatePostHeartDAOBean createPostHeartDAOBean;
    GetPostDAOBean getPostDAOBean;
    SavePostHeartDAOBean savePostHeartDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public SavePostHeartBean(CreateUniqueIdBean createUniqueIdBean, GetPostHeartDAOBean getPostHeartDAOBean, CreatePostHeartDAOBean createPostHeartDAOBean, GetPostDAOBean getPostDAOBean, SavePostHeartDAOBean savePostHeartDAOBean, SavePostDAOBean savePostDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.getPostHeartDAOBean = getPostHeartDAOBean;
        this.createPostHeartDAOBean = createPostHeartDAOBean;
        this.getPostDAOBean = getPostDAOBean;
        this.savePostHeartDAOBean = savePostHeartDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    // 게시물 좋아요 저장
    public Long exec(RequestPostHeartSaveDTO requestPostHeartSaveDTO) {

        // 중복 확인
        if (getPostHeartDAOBean.exec(requestPostHeartSaveDTO.getUserId(), requestPostHeartSaveDTO.getPostId()) != null) return -1L;

        // 게시물 좋아요 아이디 생성
        Long postHeartId = createUniqueIdBean.exec();

        // DAO 생성
        PostHeartDAO postHeartDAO = createPostHeartDAOBean.exec(postHeartId, requestPostHeartSaveDTO);

        // 게시물 좋아요 수 증가
        PostDAO postDAO = getPostDAOBean.exec(requestPostHeartSaveDTO.getPostId());
        if (postDAO == null) return null;
        postDAO.setHeartCount(postDAO.getHeartCount() + 1);

        // 게시물 좋아요 저장
        savePostHeartDAOBean.exec(postHeartDAO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        return postDAO.getPostId();
    }
}
