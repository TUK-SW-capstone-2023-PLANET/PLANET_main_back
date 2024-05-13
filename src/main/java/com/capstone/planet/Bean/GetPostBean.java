package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.*;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponsePostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPostBean {

    GetPostDAOBean getPostDAOBean;
    GetUserDAOBean getUserDAOBean;
    SavePostDAOBean savePostDAOBean;
    CreatePostDTOBean createPostDTOBean;
    GetPostHeartDAOBean getPostHeartDAOBean;

    @Autowired
    public GetPostBean(GetPostDAOBean getPostDAOBean, GetUserDAOBean getUserDAOBean, SavePostDAOBean savePostDAOBean, CreatePostDTOBean createPostDTOBean, GetPostHeartDAOBean getPostHeartDAOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.getUserDAOBean = getUserDAOBean;
        this.savePostDAOBean = savePostDAOBean;
        this.createPostDTOBean = createPostDTOBean;
        this.getPostHeartDAOBean = getPostHeartDAOBean;
    }

    // 게시물 조회
    public ResponsePostGetDTO exec(Long postId, Long userId) {

        // 게시물 찾기
        PostDAO postDAO = getPostDAOBean.exec(postId);
        if (postDAO == null) return null;

        // 게시물 해당 유저 찾기
        UserDAO userDAO = getUserDAOBean.exec(postDAO.getUserId());
        if (userDAO == null) return null;

        // 조회수 증가
        postDAO.setViewCount(postDAO.getViewCount() + 1);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // 게시물 좋아요 여부 체크
        boolean heart = getPostHeartDAOBean.exec(userId, postId) != null;

        // DTO 반환
        return createPostDTOBean.exec(postDAO, userDAO, heart);
    }
}
