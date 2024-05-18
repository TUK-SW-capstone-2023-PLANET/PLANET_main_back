package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateCommentDTOBean;
import com.capstone.planet.Bean.Small.GetCommentDAOBean;
import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Model.DTO.ResponseCommentGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCommentsBean {

    GetCommentDAOBean getCommentDAOBean;
    CreateCommentDTOBean createCommentDTOBean;

    @Autowired
    public GetCommentsBean(GetCommentDAOBean getCommentDAOBean, CreateCommentDTOBean createCommentDTOBean) {
        this.getCommentDAOBean = getCommentDAOBean;
        this.createCommentDTOBean = createCommentDTOBean;
    }

    // 댓글 전체 조회
    public List<ResponseCommentGetDTO> exec(Long postId, Long userId){

        // 게시물에 해당하는 댓글 전부 가져오기
        List<CommentDAO> commentDAOS = getCommentDAOBean.exec(postId, 0L);

        // 댓글 DTO로 변환
        return createCommentDTOBean.exec(commentDAOS);
    }
}
