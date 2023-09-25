package com.recommendation.system.api.service;

import com.recommendation.system.api.models.GenreEntity;
import com.recommendation.system.api.models.InteractionEntity;
import com.recommendation.system.api.models.MovieEntity;
import com.recommendation.system.api.models.UserEntity;
import com.recommendation.system.api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieEntity> getRecommendations(UserEntity user) {
        List<InteractionEntity> interactions = user.getInteractions(); // Assuming interactions are stored in User

        Set<String> userGenres = new HashSet<>();
        for (InteractionEntity interaction : interactions) {
            MovieEntity movie = interaction.getMovie(); // Assuming each interaction has a reference to a Movie
            List<GenreEntity> genres = movie.getGenres();
            for (GenreEntity genreEntity: genres){
                userGenres.add(genreEntity.getName());
            }
        }

        List<MovieEntity> recommendedMovies = new ArrayList<>();
        for (String genre : userGenres) {
            List<MovieEntity> moviesWithGenre = movieRepository.findByGenre(genre); // Custom query method in repository
            recommendedMovies.addAll(moviesWithGenre);
        }

        // Remove duplicates (if any)
        recommendedMovies = recommendedMovies.stream().distinct().collect(Collectors.toList());

        return recommendedMovies;
    }
}

