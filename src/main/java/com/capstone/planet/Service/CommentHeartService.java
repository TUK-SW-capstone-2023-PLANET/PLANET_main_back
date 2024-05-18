package com.capstone.planet.Service;

import com.capstone.planet.Bean.DeleteCommentHeartBean;
import com.capstone.planet.Bean.SaveCommentHeartBean;
import com.capstone.planet.Model.DTO.RequestCommentHeartDeleteDTO;
import com.capstone.planet.Model.DTO.RequestCommentHeartSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentHeartService {

    SaveCommentHeartBean saveCommentHeartBean;
    DeleteCommentHeartBean deleteCommentHeartBean;

    @Autowired
    public CommentHeartService(SaveCommentHeartBean saveCommentHeartBean, DeleteCommentHeartBean deleteCommentHeartBean) {
        this.saveCommentHeartBean = saveCommentHeartBean;
        this.deleteCommentHeartBean = deleteCommentHeartBean;
    }

    // 댓글 좋아요 저장
    public Long saveCommentHeart(RequestCommentHeartSaveDTO requestCommentHeartSaveDTO) {
        return saveCommentHeartBean.exec(requestCommentHeartSaveDTO);
    }

    // 댓글 좋아요 삭제
    public Long deleteCommentHeart(RequestCommentHeartDeleteDTO requestCommentHeartDeleteDTO) {
        return deleteCommentHeartBean.exec(requestCommentHeartDeleteDTO);
    }
}
