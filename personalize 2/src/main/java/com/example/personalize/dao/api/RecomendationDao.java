package com.example.personalize.dao.api;

import com.example.personalize.model.entity.Recommendations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecomendationDao extends JpaRepository<Recommendations,Long> {
    @Override
    List<Recommendations> findAll();

    @Override
    Recommendations save(Recommendations recommendations);


}
