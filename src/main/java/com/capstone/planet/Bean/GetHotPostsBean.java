package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateHotPostsDTOBean;
import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.ResponseHotPostsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetHotPostsBean {

    GetPostDAOBean getPostDAOBean;
    CreateHotPostsDTOBean createHotPostsDTOBean;

    @Autowired
    public GetHotPostsBean(GetPostDAOBean getPostDAOBean, CreateHotPostsDTOBean createHotPostsDTOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.createHotPostsDTOBean = createHotPostsDTOBean;
    }

    // 인기 게시물 전체 조회
    public List<ResponseHotPostsGetDTO> exec() {

        // 인기 게시물 찾기
        List<PostDAO> postDAOs = getPostDAOBean.exec();

        // DAO 객체 DTO 반환
        return createHotPostsDTOBean.exec(postDAOs);
    }
}
