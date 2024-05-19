package com.capstone.planet.Service;

import com.capstone.planet.Bean.*;
import com.capstone.planet.Model.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    GetPostBean getPostBean;
    GetHotPostBean getHotPostBean;
    GetViewPostBean getViewPostBean;
    GetPostsBean getPostsBean;
    GetHotPostsBean getHotPostsBean;
    GetMyPostsBean getMyPostsBean;
    SavePostBean savePostBean;
    DeletePostBean deletePostBean;

    @Autowired
    public PostService(GetPostBean getPostBean, GetHotPostBean getHotPostBean, GetViewPostBean getViewPostBean, GetPostsBean getPostsBean, GetHotPostsBean getHotPostsBean, GetMyPostsBean getMyPostsBean, SavePostBean savePostBean, DeletePostBean deletePostBean) {
        this.getPostBean = getPostBean;
        this.getHotPostBean = getHotPostBean;
        this.getViewPostBean = getViewPostBean;
        this.getPostsBean = getPostsBean;
        this.getHotPostsBean = getHotPostsBean;
        this.getMyPostsBean = getMyPostsBean;
        this.savePostBean = savePostBean;
        this.deletePostBean = deletePostBean;
    }

    // 게시물 가져오기
    public ResponsePostGetDTO getPost(Long postId, Long userId) {
        return getPostBean.exec(postId, userId);
    }

    // 인기 게시물 한개 가져오기
    public ResponseHotPostGetDTO getHotPost(String type) {
        return getHotPostBean.exec(type);
    }

    // 조회수 기준 게시물 가져오기
    public ResponseViewPostGetDTO getViewPost(String type) {
        return getViewPostBean.exec(type);
    }

    // 게시물 전체 가져오기
    public List<ResponsePostsGetDTO> getPosts(String type) {
        return getPostsBean.exec(type);
    }

    // 인기 게시물 가져오기
    public List<ResponseHotPostsGetDTO> getHotPosts() {
        return getHotPostsBean.exec();
    }

    // 내가 쓴 글 가져오기
    public List<ResponseMyPostGetDTO> getMyPosts(String type, Long userId) {
        return getMyPostsBean.exec(type, userId);
    }

    // 게시물 저장
    public Long savePost(String type, RequestPostSaveDTO requestPostSaveDTO) {
        return savePostBean.exec(type, requestPostSaveDTO);
    }

    // 게시물 삭제
    public Long deletePost(RequestPostDeleteDTO requestPostDeleteDTO) {
        return deletePostBean.exec(requestPostDeleteDTO);
    }
}
