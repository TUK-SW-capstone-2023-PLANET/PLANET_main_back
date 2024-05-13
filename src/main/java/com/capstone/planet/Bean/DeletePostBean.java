package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.DeleteCommentDAOBean;
import com.capstone.planet.Bean.Small.DeletePostDAOBean;
import com.capstone.planet.Bean.Small.DeletePostHeartDAOBean;
import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.RequestPostDeleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePostBean {

    GetPostDAOBean getPostDAOBean;
    DeletePostHeartDAOBean deletePostHeartDAOBean;
    DeleteCommentDAOBean deleteCommentDAOBean;
    DeletePostDAOBean deletePostDAOBean;

    @Autowired
    public DeletePostBean(GetPostDAOBean getPostDAOBean, DeletePostHeartDAOBean deletePostHeartDAOBean, DeleteCommentDAOBean deleteCommentDAOBean, DeletePostDAOBean deletePostDAOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.deletePostHeartDAOBean = deletePostHeartDAOBean;
        this.deleteCommentDAOBean = deleteCommentDAOBean;
        this.deletePostDAOBean = deletePostDAOBean;
    }

    // 게시물 삭제
    public Long exec(RequestPostDeleteDTO requestPostDeleteDTO) {

        // 게시물 찾기
        PostDAO postDAO = getPostDAOBean.exec(requestPostDeleteDTO.getPostId());
        if (postDAO == null) return null;

        // 자기 자신 작성 게시물 확인
        if (!postDAO.getUserId().equals(requestPostDeleteDTO.getUserId())) return -1L;

        // 게시물 좋아요 전부 삭제
        deletePostHeartDAOBean.exec(postDAO.getPostId());

        // 게시물 댓글 전부 삭제
        deleteCommentDAOBean.exec(postDAO.getPostId());

        // 게시물 삭제
        deletePostDAOBean.exec(postDAO);

        return postDAO.getPostId();
    }
}
