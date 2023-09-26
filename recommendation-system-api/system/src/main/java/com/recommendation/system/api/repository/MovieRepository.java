package com.recommendation.system.api.repository;

import com.recommendation.system.api.models.GenreEntity;
import com.recommendation.system.api.models.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    List<MovieEntity> findByGenresIn(List<GenreEntity> genres);
}


