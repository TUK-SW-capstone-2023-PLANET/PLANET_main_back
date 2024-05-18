package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.DeleteCommentHeartDAOBean;
import com.capstone.planet.Bean.Small.GetCommentDAOBean;
import com.capstone.planet.Bean.Small.GetCommentHeartDAOBean;
import com.capstone.planet.Bean.Small.SaveCommentDAOBean;
import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Model.DAO.CommentHeartDAO;
import com.capstone.planet.Model.DTO.RequestCommentHeartDeleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCommentHeartBean {

    GetCommentHeartDAOBean getCommentHeartDAOBean;
    GetCommentDAOBean getCommentDAOBean;
    DeleteCommentHeartDAOBean deleteCommentHeartDAOBean;
    SaveCommentDAOBean saveCommentDAOBean;

    @Autowired
    public DeleteCommentHeartBean(GetCommentHeartDAOBean getCommentHeartDAOBean, GetCommentDAOBean getCommentDAOBean, DeleteCommentHeartDAOBean deleteCommentHeartDAOBean, SaveCommentDAOBean saveCommentDAOBean) {
        this.getCommentHeartDAOBean = getCommentHeartDAOBean;
        this.getCommentDAOBean = getCommentDAOBean;
        this.deleteCommentHeartDAOBean = deleteCommentHeartDAOBean;
        this.saveCommentDAOBean = saveCommentDAOBean;
    }

    // 댓글 좋아요 삭제
    public Long exec(RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO) {

        // 댓글 좋아요 중복 확인
        CommentHeartDAO commentHeartDAO = getCommentHeartDAOBean.exec(requestCommentHeartDeleteDTO.getCommentId(), requestCommentHeartDeleteDTO.getUserId());
        if (commentHeartDAO == null) return -1L;

        CommentDAO commentDAO = getCommentDAOBean.exec(requestCommentHeartDeleteDTO.getCommentId());
        if (commentDAO == null) return null;
        commentDAO.setHeartCount(commentDAO.getHeartCount() - 1);

        // 댓글 좋아요 삭제
        deleteCommentHeartDAOBean.exec(commentHeartDAO);

        // 댓글 저장
        saveCommentDAOBean.exec(commentDAO);

        return commentDAO.getCommentId();
    }
}
