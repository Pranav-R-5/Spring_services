package com.example.personalize.service;

import com.example.personalize.data.PublishProduct;
import com.example.personalize.model.entity.Recommendationsvo.RecommendationsVo;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface PersonaliseService {
        List<RecommendationsVo> getRecommendations(Long customerId);
        String addRecommendation(RecommendationsVo recommendationVo);
         void listen(String message) throws JsonProcessingException;

    }
