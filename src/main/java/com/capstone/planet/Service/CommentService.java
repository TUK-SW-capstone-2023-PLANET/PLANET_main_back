package com.capstone.planet.Service;

import com.capstone.planet.Bean.SaveCommentBean;
import com.capstone.planet.Model.DTO.RequestCommentSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    SaveCommentBean saveCommentBean;

    @Autowired
    public CommentService(SaveCommentBean saveCommentBean) {
        this.saveCommentBean = saveCommentBean;
    }

    // 댓글 저장
    public Long saveComment(RequestCommentSaveDTO requestCommentSaveDTO) {
        return saveCommentBean.exec(requestCommentSaveDTO);
    }
}
