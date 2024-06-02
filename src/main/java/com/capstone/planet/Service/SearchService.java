package com.capstone.planet.Service;

import com.capstone.planet.Bean.*;
import com.capstone.planet.Model.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    GetSearchPostBean getSearchPostBean;
    GetSearchChatBean getSearchChatBean;
    GetSearchPloggingBean getSearchPloggingBean;
    GetSearchSeasonBean getSearchSeasonBean;
    GetSearchUniversityBean getSearchUniversityBean;
    GetSearchUniversityUserBean getSearchUniversityUserBean;

    @Autowired
    public SearchService(GetSearchPostBean getSearchPostBean, GetSearchChatBean getSearchChatBean, GetSearchPloggingBean getSearchPloggingBean, GetSearchSeasonBean getSearchSeasonBean, GetSearchUniversityBean getSearchUniversityBean, GetSearchUniversityUserBean getSearchUniversityUserBean) {
        this.getSearchPostBean = getSearchPostBean;
        this.getSearchChatBean = getSearchChatBean;
        this.getSearchPloggingBean = getSearchPloggingBean;
        this.getSearchSeasonBean = getSearchSeasonBean;
        this.getSearchUniversityBean = getSearchUniversityBean;
        this.getSearchUniversityUserBean = getSearchUniversityUserBean;
    }

    // 게시글 검색 조회
    public List<ResponsePostsGetDTO> getSearchPosts(String type, String search){
        return getSearchPostBean.exec(type, search);
    }

    // 쪽지함 검색 조회
    public List<ResponseChatRoomGetDTO> getSearchChatRooms(Long userId, String search){
        return getSearchChatBean.exec(userId, search);
    }

    // 유저 랭킹 검색 조회
    public List<ResponseUserRanksGetDTO> getSearchPlogging(String search){
        return getSearchPloggingBean.exec(search);
    }

    // 시즌 랭킹 검색 조회
    public List<ResponseSeasonUserGetDTO> getSearchSeason(String search){
        return getSearchSeasonBean.exec(search);
    }

    // 대학교 랭킹 검색 조회
    public List<ResponseUniversityGetDTO> getSearchUniversity(String search){
        return getSearchUniversityBean.exec(search);
    }

    // 대학교 유저 랭킹 검색 조회
    public List<ResponseUserUniversityGetDTO> getSearchUniversityUser(Long userId, String search){
        return getSearchUniversityUserBean.exec(userId, search);
    }
}
