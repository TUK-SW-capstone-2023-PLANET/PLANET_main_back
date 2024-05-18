package com.capstone.planet.Service;

import com.capstone.planet.Bean.DeleteCommentBean;
import com.capstone.planet.Bean.SaveCommentBean;
import com.capstone.planet.Model.DTO.RequestCommentDeleteDTO;
import com.capstone.planet.Model.DTO.RequestCommentSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    SaveCommentBean saveCommentBean;
    DeleteCommentBean deleteCommentBean;

    @Autowired
    public CommentService(SaveCommentBean saveCommentBean, DeleteCommentBean deleteCommentBean) {
        this.saveCommentBean = saveCommentBean;
        this.deleteCommentBean = deleteCommentBean;
    }

    // 댓글 저장
    public Long saveComment(RequestCommentSaveDTO requestCommentSaveDTO) {
        return saveCommentBean.exec(requestCommentSaveDTO);
    }

    // 댓글 삭제
    public Long deleteComment(RequestCommentDeleteDTO requestCommentDeleteDTO) {
        return deleteCommentBean.exec(requestCommentDeleteDTO);
    }
}
