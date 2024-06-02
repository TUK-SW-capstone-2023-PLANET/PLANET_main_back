package com.capstone.planet.Bean;

import com.capstone.planet.Model.DTO.ResponsePostsGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSearchPostBean {

    GetPostsBean getPostsBean;

    @Autowired
    public GetSearchPostBean(GetPostsBean getPostsBean) {
        this.getPostsBean = getPostsBean;
    }

    // 게시글 검색 조회
    public List<ResponsePostsGetDTO> exec(String type, String search) {

        List<ResponsePostsGetDTO> responsePostsGetDTOS = getPostsBean.exec(type);

        // 게시글 검색 조회 메서드
        return responsePostsGetDTOS.stream()
                .filter(responsePostsGetDTO -> responsePostsGetDTO.getTitle().contains(search))
                .collect(Collectors.toList());
    }
}