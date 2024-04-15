package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.UserDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepositoryJPA extends JpaRepository<UserDAO, Long> {

    boolean existsByEmail(String email);

    List<UserDAO> findByUniversityNameOrderByScoreDesc(String universityName);

    List<UserDAO> findTop3ByOrderByScoreDesc();

    List<UserDAO> findAllByOrderByScoreDesc();

    Page<UserDAO> findByUniversityName(String universityName, Pageable pageable);
}
