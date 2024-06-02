package com.capstone.planet.Service;

import com.capstone.planet.Bean.GetSearchPostBean;
import com.capstone.planet.Model.DTO.ResponsePostsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    GetSearchPostBean getSearchPostBean;

    @Autowired
    public SearchService(GetSearchPostBean getSearchPostBean) {
        this.getSearchPostBean = getSearchPostBean;
    }

    // 게시글 검색 조회
    public List<ResponsePostsGetDTO> getSearchPosts(String type, String search){
        return getSearchPostBean.exec(type, search);
    }
}
