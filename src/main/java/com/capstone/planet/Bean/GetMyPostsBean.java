package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateMyPostsDTOBean;
import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Bean.Small.GetUserDAOBean;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.UserDAO;
import com.capstone.planet.Model.DTO.ResponseMyPostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetMyPostsBean {

    GetPostDAOBean getPostDAOBean;
    GetUserDAOBean getUserDAOBean;
    CreateMyPostsDTOBean createMyPostsDTOBean;

    @Autowired
    public GetMyPostsBean(GetPostDAOBean getPostDAOBean, GetUserDAOBean getUserDAOBean, CreateMyPostsDTOBean createMyPostsDTOBean) {
        this.getPostDAOBean = getPostDAOBean;
        this.getUserDAOBean = getUserDAOBean;
        this.createMyPostsDTOBean = createMyPostsDTOBean;
    }

    // 내가 쓴 글 조회
    public List<ResponseMyPostGetDTO> exec(String type, Long userId){

        List<PostDAO> postDAOS = getPostDAOBean.exec(userId, 1L);

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
