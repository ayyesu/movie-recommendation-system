package com.recommendation.system.api.controller;

import com.recommendation.system.api.models.MovieEntity;
import com.recommendation.system.api.models.UserEntity;
import com.recommendation.system.api.service.RecommendationService;
import com.recommendation.system.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<MovieEntity>> getRecommendationsForUser(@PathVariable Integer userId) {
        UserEntity user = userService.getUserById(userId);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        List<MovieEntity> recommendations = recommendationService.getRecommendations(user);

        return ResponseEntity.ok(recommendations);
    }
}
