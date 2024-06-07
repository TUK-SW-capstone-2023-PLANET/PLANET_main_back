package com.capstone.planet.Service;

import com.capstone.planet.Bean.*;
import com.capstone.planet.Model.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SearchService {

    GetSearchPostBean getSearchPostBean;
    GetSearchChatBean getSearchChatBean;
    GetSearchPloggingBean getSearchPloggingBean;
    GetSearchSeasonBean getSearchSeasonBean;
    GetSearchUniversityBean getSearchUniversityBean;
    GetSearchUniversityUserBean getSearchUniversityUserBean;
    GetSearchMyPostBean getSearchMyPostBean;
    GetSearchMyCommentPostBean getSearchMyCommentPostBean;
    GetSearchMapBean getSearchMapBean;
    GetPostHistoryBean getPostHistoryBean;
    GetMapHistoryBean getMapHistoryBean;

    @Autowired
    public SearchService(GetSearchPostBean getSearchPostBean, GetSearchChatBean getSearchChatBean, GetSearchPloggingBean getSearchPloggingBean, GetSearchSeasonBean getSearchSeasonBean, GetSearchUniversityBean getSearchUniversityBean, GetSearchUniversityUserBean getSearchUniversityUserBean, GetSearchMyPostBean getSearchMyPostBean, GetSearchMyCommentPostBean getSearchMyCommentPostBean, GetSearchMapBean getSearchMapBean, GetPostHistoryBean getPostHistoryBean, GetMapHistoryBean getMapHistoryBean) {
        this.getSearchPostBean = getSearchPostBean;
        this.getSearchChatBean = getSearchChatBean;
        this.getSearchPloggingBean = getSearchPloggingBean;
        this.getSearchSeasonBean = getSearchSeasonBean;
        this.getSearchUniversityBean = getSearchUniversityBean;
        this.getSearchUniversityUserBean = getSearchUniversityUserBean;
        this.getSearchMyPostBean = getSearchMyPostBean;
        this.getSearchMyCommentPostBean = getSearchMyCommentPostBean;
        this.getSearchMapBean = getSearchMapBean;
        this.getPostHistoryBean = getPostHistoryBean;
        this.getMapHistoryBean = getMapHistoryBean;
    }

    // 게시글 검색 조회
    public List<ResponsePostsGetDTO> getSearchPosts(Long userId, String type, String search){
        return getSearchPostBean.exec(userId, type, search);
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

    // 내가 작성한 게시물 검색 조회
    public List<ResponseMyPostGetDTO> getSearchMyPost(Long userId, String type, String search){
        return getSearchMyPostBean.exec(userId, type, search);
    }

    // 내가 작성한 댓글이 있는 게시물 검색 조회
    public List<ResponseMyPostGetDTO> getSearchMyCommentPost(Long userId, String type, String search){
        return getSearchMyCommentPostBean.exec(userId, type, search);
    }

    // 지도 검색 조회
    public ResponseSearchMapGetDTO getSearchMap(Long userId, String search){
        return getSearchMapBean.exec(userId, search);
    }

    // 게시물 히스토리 조회
    public List<String> getPostHistory(Long userId){
        return getPostHistoryBean.exec(userId);
    }

    // 지도 히스토리 조회
    public List<Map<String, String>> getMapHistory(Long userId){
        return getMapHistoryBean.exec(userId);
    }

}
