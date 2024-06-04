package com.capstone.planet.Bean;

import com.capstone.planet.Model.DTO.ResponseMyPostGetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetSearchMyPostBean {

    GetMyPostsBean getMyPostsBean;

    @Autowired
    public GetSearchMyPostBean(GetMyPostsBean getMyPostsBean) {
        this.getMyPostsBean = getMyPostsBean;
    }

    // 내가 작성한 게시물 검색
    public List<ResponseMyPostGetDTO> exec(Long userId, String type, String search){

        List<ResponseMyPostGetDTO> responseMyPostGetDTOS = getMyPostsBean.exec(type, userId);

        return responseMyPostGetDTOS.stream()
                .filter(responseMyPostGetDTO -> responseMyPostGetDTO.getTitle().contains(search))
                .collect(Collectors.toList());

    }
}
