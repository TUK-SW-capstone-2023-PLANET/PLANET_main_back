package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreatePostsDTOBean;
import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.ResponsePostsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetPostsBean {

    GetPostDAOBean getPostDAOBean;
    CreatePostsDTOBean createPostsDTOBean;

    @Autowired
    public GetPostsBean(GetPostDAOBean getPostDAOBean, CreatePostsDTOBean createPostsDTOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.createPostsDTOBean = createPostsDTOBean;
    }

    // 게시물 전체 조회
    public List<ResponsePostsGetDTO> exec(String type){

        // type에 따라 게시물 조회 및 시간으로 정렬
        List<PostDAO> postDAOS = getPostDAOBean.exec(type);

        // DTO 객체 반환
        return createPostsDTOBean.exec(postDAOS);
    }
}
