package com.recommendation.system.api.service;

import com.recommendation.system.api.models.GenreEntity;
import com.recommendation.system.api.models.InteractionEntity;
import com.recommendation.system.api.models.MovieEntity;
import com.recommendation.system.api.models.UserEntity;
import com.recommendation.system.api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieEntity> getRecommendations(UserEntity user) {
        List<InteractionEntity> interactions = user.getInteractions();

        Set<GenreEntity> userGenres = new HashSet<>();
        for (InteractionEntity interaction : interactions) {
            MovieEntity movie = interaction.getMovie();
            List<GenreEntity> genres = movie.getGenres();
            userGenres.addAll(genres);
        }

        List<MovieEntity> recommendedMovies = new ArrayList<>();
        for (GenreEntity genre : userGenres) {
            List<MovieEntity> moviesWithGenre = movieRepository.findByGenresIn(Collections.singletonList(genre));
            recommendedMovies.addAll(moviesWithGenre);
        }

        // Remove duplicates (if any)
        recommendedMovies = recommendedMovies.stream().distinct().collect(Collectors.toList());

        return recommendedMovies;
    }

}

