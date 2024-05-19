package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.PostDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepositoryJPA extends JpaRepository<PostDAO, Long> {

    List<PostDAO> findByTypeOrderByUploadTimeDesc(String type);

    List<PostDAO> findTop10ByTypeOrderByHeartCountDescUploadTimeDesc(String type);

    PostDAO findTop1ByTypeOrderByHeartCountDescUploadTimeDesc(String type);

    PostDAO findTop1ByTypeOrderByViewCountDescUploadTimeDesc(String type);

    List<PostDAO> findByUserIdOrderByUploadTimeDesc(Long userId);

    List<PostDAO> findAllByPostIdInOrderByUploadTimeDesc(List<Long> postIds);
}
