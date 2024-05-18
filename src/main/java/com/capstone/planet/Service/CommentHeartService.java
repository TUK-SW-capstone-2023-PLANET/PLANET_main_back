package com.capstone.planet.Service;

import com.capstone.planet.Bean.SaveCommentHeartBean;
import com.capstone.planet.Model.DTO.RequestCommentHeartSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentHeartService {

    SaveCommentHeartBean saveCommentHeartBean;

    @Autowired
    public CommentHeartService(SaveCommentHeartBean saveCommentHeartBean) {
        this.saveCommentHeartBean = saveCommentHeartBean;
    }

    // 댓글 좋아요 저장
    public Long saveCommentHeart(RequestCommentHeartSaveDTO requestCommentHeartSaveDTO) {
        return saveCommentHeartBean.exec(requestCommentHeartSaveDTO);
    }
}
