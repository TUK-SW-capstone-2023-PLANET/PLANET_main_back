package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.DeletePostHeartDAOBean;
import com.capstone.planet.Bean.Small.GetPostDAOBean;
import com.capstone.planet.Bean.Small.GetPostHeartDAOBean;
import com.capstone.planet.Bean.Small.SavePostDAOBean;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DAO.PostHeartDAO;
import com.capstone.planet.Model.DTO.RequestPostHeartDeleteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeletePostHeartBean {

    GetPostHeartDAOBean getPostHeartDAOBean;
    GetPostDAOBean getPostDAOBean;
    SavePostDAOBean savePostDAOBean;
    DeletePostHeartDAOBean deletePostHeartDAOBean;

    @Autowired
    public DeletePostHeartBean(GetPostHeartDAOBean getPostHeartDAOBean, GetPostDAOBean getPostDAOBean, SavePostDAOBean savePostDAOBean, DeletePostHeartDAOBean deletePostHeartDAOBean) {
        this.getPostHeartDAOBean = getPostHeartDAOBean;
        this.getPostDAOBean = getPostDAOBean;
        this.savePostDAOBean = savePostDAOBean;
        this.deletePostHeartDAOBean = deletePostHeartDAOBean;
    }

    public Long exec(RequestPostHeartDeleteDTO requestPostHeartDeleteDTO) {

        // 게시물 좋아요 중복 확인
        PostHeartDAO postHeartDAO = getPostHeartDAOBean.exec(requestPostHeartDeleteDTO.getUserId(), requestPostHeartDeleteDTO.getPostId());
        if (postHeartDAO == null) return -1L;

        PostDAO postDAO = getPostDAOBean.exec(requestPostHeartDeleteDTO.getPostId());
        if (postDAO == null) return null;
        postDAO.setHeartCount(postDAO.getHeartCount() - 1);

        // 게시물 좋아요 삭제
        deletePostHeartDAOBean.exec(postHeartDAO);

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        return postDAO.getPostId();
    }
}
