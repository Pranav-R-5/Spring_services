package com.example.personalize.controller;

import com.example.personalize.data.PublishProduct;
import com.example.personalize.model.entity.Recommendationsvo.RecommendationsVo;
import com.example.personalize.service.PersonaliseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/httpmethod")

public class httpcontroller {

    @Autowired
    PersonaliseService personaliseService;


    @GetMapping("/getRecomendations")
    public List<RecommendationsVo> getRecommendations(@RequestParam(value = "customerId") long customerId ){
        return personaliseService.getRecommendations(customerId);
    }

    @PostMapping("/addRecomendation")
    public String addRecommendation(@RequestBody RecommendationsVo recommendationVo){
        return personaliseService.addRecommendation(recommendationVo);

    }



}