package com.capstone.planet.Repository;

import com.capstone.planet.Model.DAO.PloggingDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PloggingRepositoryJPA extends JpaRepository<PloggingDAO, Long> {
    List<PloggingDAO> findByUserIdAndMonthOrderByDayAsc(Long userId, String month);

    List<PloggingDAO> findByUserIdOrderByMonthDesc(Long userId);
}
