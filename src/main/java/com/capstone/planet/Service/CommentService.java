package com.capstone.planet.Service;

import com.capstone.planet.Bean.DeleteCommentBean;
import com.capstone.planet.Bean.GetCommentsBean;
import com.capstone.planet.Bean.SaveCommentBean;
import com.capstone.planet.Model.DTO.RequestCommentDeleteDTO;
import com.capstone.planet.Model.DTO.RequestCommentSaveDTO;
import com.capstone.planet.Model.DTO.ResponseCommentGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    GetCommentsBean getCommentsBean;
    SaveCommentBean saveCommentBean;
    DeleteCommentBean deleteCommentBean;

    @Autowired
    public CommentService(GetCommentsBean getCommentsBean, SaveCommentBean saveCommentBean, DeleteCommentBean deleteCommentBean) {
        this.getCommentsBean = getCommentsBean;
        this.saveCommentBean = saveCommentBean;
        this.deleteCommentBean = deleteCommentBean;
    }

    // 댓글 조회
    public List<ResponseCommentGetDTO> getComments(Long postId, Long userId) {
        return getCommentsBean.exec(postId, userId);
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
