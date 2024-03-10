package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.AdvertisementDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepositoryJPA extends JpaRepository<AdvertisementDAO, Long> {
}
