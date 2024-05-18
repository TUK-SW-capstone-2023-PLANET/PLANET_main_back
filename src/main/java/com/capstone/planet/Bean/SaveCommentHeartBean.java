package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.*;
import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Model.DAO.CommentHeartDAO;
import com.capstone.planet.Model.DTO.RequestCommentHeartSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveCommentHeartBean {

    GetCommentHeartDAOBean getCommentHeartDAOBean;
    CreateUniqueIdBean createUniqueIdBean;
    CreateCommentHeartDAOBean createCommentHeartDAOBean;
    GetCommentDAOBean getCommentDAOBean;
    SaveCommentHeartDAOBean saveCommentHeartDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;

    @Autowired
    public SaveCommentHeartBean(GetCommentHeartDAOBean getCommentHeartDAOBean, CreateUniqueIdBean createUniqueIdBean, CreateCommentHeartDAOBean createCommentHeartDAOBean, GetCommentDAOBean getCommentDAOBean, SaveCommentHeartDAOBean saveCommentHeartDAOBean, SaveCommentDAOBean saveCommentDAOBean) {
        this.getCommentHeartDAOBean = getCommentHeartDAOBean;
        this.createUniqueIdBean = createUniqueIdBean;
        this.createCommentHeartDAOBean = createCommentHeartDAOBean;
        this.getCommentDAOBean = getCommentDAOBean;
        this.saveCommentHeartDAOBean = saveCommentHeartDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
    }

    // 댓글 좋아요 저장
    public Long exec(RequestCommentHeartSaveDTO requestCommentHeartSaveDTO){

        // 중복 확인
        if (getCommentHeartDAOBean.exec(requestCommentHeartSaveDTO.getUserId(), requestCommentHeartSaveDTO.getCommentId()) != null) return -1L;

        // 댓글 좋아요 아이디 생성
        Long commentHeartId = createUniqueIdBean.exec();

        // DAO 생성
        CommentHeartDAO commentHeartDAO = createCommentHeartDAOBean.exec(commentHeartId, requestCommentHeartSaveDTO);

        // 댓글 좋아요 수 증가
        CommentDAO commentDAO = getCommentDAOBean.exec(requestCommentHeartSaveDTO.getCommentId());
        if (commentDAO == null) return null;
        commentDAO.setHeartCount(commentDAO.getHeartCount() + 1);

        // 댓글 좋아요 저장
        saveCommentHeartDAOBean.exec(commentHeartDAO);

        // 댓글 저장
        saveCommentDAOBean.exec(commentDAO);

        return commentDAO.getCommentId();

    }
}
