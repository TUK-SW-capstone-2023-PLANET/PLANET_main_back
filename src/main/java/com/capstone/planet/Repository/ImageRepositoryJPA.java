package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.ImageDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepositoryJPA extends JpaRepository<ImageDAO, Long>{
}
