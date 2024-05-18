package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreatePostDAOBean;
import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.SavePostDAOBean;
import com.capstone.planet.Model.DAO.PostDAO;
import com.capstone.planet.Model.DTO.RequestPostSaveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavePostBean {

    CreateUniqueIdBean createUniqueIdBean;
    CreatePostDAOBean createPostDAOBean;
    SavePostDAOBean savePostDAOBean;

    @Autowired
    public SavePostBean(CreateUniqueIdBean createUniqueIdBean, CreatePostDAOBean createPostDAOBean, SavePostDAOBean savePostDAOBean) {
        this.createUniqueIdBean = createUniqueIdBean;
        this.createPostDAOBean = createPostDAOBean;
        this.savePostDAOBean = savePostDAOBean;
    }

    // 게시물 저장
    public Long exec(String type, RequestPostSaveDTO requestPostSaveDTO) {

        // 게시물 id 생성
        Long postId = createUniqueIdBean.exec();

        // 게시물 DAO 생성
        PostDAO postDAO = createPostDAOBean.exec(postId, type, requestPostSaveDTO);
        if (postDAO == null) return null;

        // 게시물 저장
        savePostDAOBean.exec(postDAO);

        return postId;
    }
}
