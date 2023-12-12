package com.example.personalize.serviceimplementation;

import com.example.personalize.dao.api.RecomendationDao;
import com.example.personalize.data.PublishProduct;
import com.example.personalize.model.entity.Recommendations;
import com.example.personalize.model.entity.Recommendationsvo.RecommendationsVo;
import com.example.personalize.model.entity.vo.ProductVO;
import com.example.personalize.service.PersonaliseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("personaliseService")
public class Personalservice_impl implements PersonaliseService {

    @Autowired
    RecomendationDao recommendationsDao;

    public static final String topic="com.quinbay.product.create";

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @KafkaListener(topics = "com.quinbay.product.create", groupId = "group-id")
    public void listen(String message) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ProductVO p = objectMapper.readValue(message, ProductVO.class);
        System.out.println("received: " + p);
    }

    @Override
    public List<RecommendationsVo> getRecommendations(Long customerId) {

            List<Recommendations> productList=recommendationsDao.findAll();
            ObjectMapper objectMapper=new ObjectMapper();

            List<RecommendationsVo> recommendations= objectMapper.convertValue(productList,List.class);

            return recommendations;
    }

    @Override
    public String addRecommendation(RecommendationsVo recommendationVo) {

            ObjectMapper objectMapper=new ObjectMapper();
            recommendationsDao.save(objectMapper.convertValue(recommendationVo, Recommendations.class));
            return "Success";
    }
}
