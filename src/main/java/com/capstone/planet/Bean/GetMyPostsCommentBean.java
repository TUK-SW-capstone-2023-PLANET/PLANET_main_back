package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateMyPostsDTOBean;
import com.capstone.planet.Bean.Small.GetCommentDAOBean;
import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.CommentDAO;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseMyPostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class GetMyPostsCommentBean {

    GetCommentDAOBean getCommentDAOBean;
    GetPostDAOBean getPostDAOBean;
    GetUserDAOBean getUserDAOBean;
    CreateMyPostsDTOBean createMyPostsDTOBean;

    @Autowired
    public GetMyPostsCommentBean(GetCommentDAOBean getCommentDAOBean, GetPostDAOBean getPostDAOBean, GetUserDAOBean getUserDAOBean, CreateMyPostsDTOBean createMyPostsDTOBean) {
        this.getCommentDAOBean = getCommentDAOBean;
        this.getPostDAOBean = getPostDAOBean;
        this.getUserDAOBean = getUserDAOBean;
        this.createMyPostsDTOBean = createMyPostsDTOBean;
    }

    // 내가 쓴 댓글의 게시물 조회
    public List<ResponseMyPostGetDTO> exec(String type, Long userId){

        List<CommentDAO> commentDAOS = getCommentDAOBean.exec(userId, "check");

        // 중복 제거
        Set<Long> uniquePostIds = commentDAOS.stream()
                .map(CommentDAO::getPostId)
                .collect(Collectors.toSet());
        // Set을 List로 변환
        List<Long> postIds =  uniquePostIds.stream().toList();

        List<PostDAO> postDAOS = getPostDAOBean.exec(postIds);

        if (type.equals("all"))
            return createMyPostsDTOBean.exec(postDAOS);

        if (type.equals("free")) {
            postDAOS = postDAOS.stream().filter(postDAO -> postDAO.getType().equals("free")).toList();
        }else {
            UserDAO userDAO = getUserDAOBean.exec(Long.parseLong(type));
            if (userDAO == null) return null;
            postDAOS = postDAOS.stream().filter(postDAO -> postDAO.getType().equals(userDAO.getUniversityName())).toList();
        }

        return createMyPostsDTOBean.exec(postDAOS);
    }
}
