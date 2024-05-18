package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.DeleteCommentDAOBean;
import com.capstone.planet.Bean.Small.GetCommentDAOBean;
import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Bean.Small.SavePostDAOBean;
import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.RequestCommentDeleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentBean {

    GetCommentDAOBean getCommentDAOBean;
    GetPostDAOBean getPostDAOBean;
    DeleteCommentDAOBean deleteCommentDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public DeleteCommentBean(GetCommentDAOBean getCommentDAOBean, GetPostDAOBean getPostDAOBean, DeleteCommentDAOBean deleteCommentDAOBean, SavePostDAOBean savePostDAOBean) {
        this.getCommentDAOBean = getCommentDAOBean;
        this.getPostDAOBean = getPostDAOBean;
        this.deleteCommentDAOBean = deleteCommentDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    // 댓글 삭제
    public Long exec(RequestCommentDeleteDTO requestCommentDeleteDTO){

        // 댓글 가져오기
        CommentDAO commentDAO = getCommentDAOBean.exec(requestCommentDeleteDTO.getCommentId());
        if (commentDAO == null) return null;

        // 유저 확인
        if (!commentDAO.getUserId().equals(requestCommentDeleteDTO.getUserId())) return null;

        // 게시물 댓글 수 감소
        PostDAO postDAO = getPostDAOBean.exec(commentDAO.getPostId());
        if (postDAO == null) return null;
        postDAO.setCommentCount(postDAO.getCommentCount() - 1);

        // 댓글 저장
        deleteCommentDAOBean.exec(commentDAO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        return commentDAO.getCommentId();
    }
}
