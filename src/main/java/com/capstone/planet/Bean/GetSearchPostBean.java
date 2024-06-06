package com.capstone.planet.Bean;

import com.capstone.planet.Bean.Small.CreateUniqueIdBean;
import com.capstone.planet.Bean.Small.DeletePostSearchHistoryDAOBean;
import com.capstone.planet.Bean.Small.GetPostSearchHistoryDAOBean;
import com.capstone.planet.Bean.Small.SavePostSearchHistoryDAOBean;
import com.capstone.planet.Model.DAO.PostSearchHistoryDAO;
import com.capstone.planet.Model.DTO.ResponsePostsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSearchPostBean {

    GetPostsBean getPostsBean;
    CreateUniqueIdBean createUniqueIdBean;
    GetPostSearchHistoryDAOBean getPostSearchHistoryDAOBean;
    DeletePostSearchHistoryDAOBean deletePostSearchHistoryDAOBean;
    SavePostSearchHistoryDAOBean savePostSearchHistoryDAOBean;

    @Autowired
    public GetSearchPostBean(GetPostsBean getPostsBean, CreateUniqueIdBean createUniqueIdBean, GetPostSearchHistoryDAOBean getPostSearchHistoryDAOBean, DeletePostSearchHistoryDAOBean deletePostSearchHistoryDAOBean, SavePostSearchHistoryDAOBean savePostSearchHistoryDAOBean) {
        this.getPostsBean = getPostsBean;
        this.createUniqueIdBean = createUniqueIdBean;
        this.getPostSearchHistoryDAOBean = getPostSearchHistoryDAOBean;
        this.deletePostSearchHistoryDAOBean = deletePostSearchHistoryDAOBean;
        this.savePostSearchHistoryDAOBean = savePostSearchHistoryDAOBean;
    }

    // 게시글 검색 조회
    public List<ResponsePostsGetDTO> exec(Long userId, String type, String search) {

        List<ResponsePostsGetDTO> responsePostsGetDTOS = getPostsBean.exec(type);

        // 게시글 검색 히스토리 저장
        PostSearchHistoryDAO searchDAO = new PostSearchHistoryDAO();
        searchDAO.setPostSearchHistoryId(createUniqueIdBean.exec());
        searchDAO.setUserId(userId);
        searchDAO.setSearch(search);
        searchDAO.setUploadTime(LocalDateTime.now());

        savePostSearchHistoryDAOBean.exec(searchDAO);

        List<PostSearchHistoryDAO> postSearchHistoryDAOS = getPostSearchHistoryDAOBean.exec(userId);

        if (postSearchHistoryDAOS.size() > 5) {
            List<PostSearchHistoryDAO> itemsToDelete = postSearchHistoryDAOS.stream()
                    .skip(5)
                    .collect(Collectors.toList());

            // 나머지 항목들 삭제
            deletePostSearchHistoryDAOBean.exec(itemsToDelete);
        }


        // 게시글 검색 조회 메서드
        return responsePostsGetDTOS.stream()
                .filter(responsePostsGetDTO -> responsePostsGetDTO.getTitle().contains(search))
                .collect(Collectors.toList());
    }
}