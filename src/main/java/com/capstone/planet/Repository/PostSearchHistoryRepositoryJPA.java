package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.PostSearchHistoryDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostSearchHistoryRepositoryJPA  extends JpaRepository<PostSearchHistoryDAO, Long>{

    List<PostSearchHistoryDAO> findByUserIdOrderByUploadTimeDesc(Long userId);
}
