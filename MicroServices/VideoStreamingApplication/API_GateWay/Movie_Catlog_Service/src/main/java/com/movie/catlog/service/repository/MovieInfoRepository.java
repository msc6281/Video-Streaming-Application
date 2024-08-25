package com.movie.catlog.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.catlog.service.model.MovieInfo;

@Repository
public interface MovieInfoRepository extends JpaRepository<MovieInfo,Long>{

}
