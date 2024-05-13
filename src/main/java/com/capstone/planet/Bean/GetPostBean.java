package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreatePostDTOBean;
import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponsePostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPostBean {

    GetPostDAOBean getPostDAOBean;
    GetUserDAOBean getUserDAOBean;
    CreatePostDTOBean createPostDTOBean;

    @Autowired
    public GetPostBean(GetPostDAOBean getPostDAOBean, GetUserDAOBean getUserDAOBean, CreatePostDTOBean createPostDTOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.getUserDAOBean = getUserDAOBean;
        this.createPostDTOBean = createPostDTOBean;
    }

    public ResponsePostGetDTO exec(Long postId, Long userId) {

        // 게시물 찾기
        PostDAO postDAO = getPostDAOBean.exec(postId);
        if (postDAO == null) return null;

        // 게시물 해당 유저 찾기
        UserDAO userDAO = getUserDAOBean.exec(postDAO.getUserId());
        if (userDAO == null) return null;

        // 게시물 좋아요 여부 체크

        // DTO 반환
        return createPostDTOBean.exec(postDAO, userDAO, userId);
    }
}
