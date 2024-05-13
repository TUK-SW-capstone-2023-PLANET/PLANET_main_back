package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.*;
import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.RequestCommentSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreateCommentDAOBean createCommentDAOBean;
    GetPostDAOBean getPostDAOBean;
    SavePostDAOBean savePostDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;

    @Autowired
    public SaveCommentBean(CreateUniqueIdBean createUniqueIdBean, CreateCommentDAOBean createCommentDAOBean, GetPostDAOBean getPostDAOBean, SavePostDAOBean savePostDAOBean, SaveCommentDAOBean saveCommentDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createCommentDAOBean = createCommentDAOBean;
        this.getPostDAOBean = getPostDAOBean;
        this.savePostDAOBean = savePostDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
    }

    // 댓글 저장
    public Long exec(RequestCommentSaveDTO requestCommentSaveDTO) {

        // 댓글 아이디 생성
        Long commentId = createUniqueIdBean.exec();

        // 댓글 DAO 생성
        CommentDAO commentDAO = createCommentDAOBean.exec(commentId, requestCommentSaveDTO);

        // 게시물 댓글 수 증가
        PostDAO postDAO = getPostDAOBean.exec(requestCommentSaveDTO.getPostId());
        if (postDAO == null) return null;
        postDAO.setCommentCount(postDAO.getCommentCount() + 1);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        // 댓글 저장
        saveCommentDAOBean.exec(commentDAO);

        return commentId;
    }
}
