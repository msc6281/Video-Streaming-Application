package com.movie.catlog.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.catlog.service.model.MovieInfo;
import com.movie.catlog.service.repository.MovieInfoRepository;

@RestController
public class MovieInfoController {
	
	@Autowired
	private MovieInfoRepository mvRepository;

	@PostMapping("/movie-info/save")
	public List<MovieInfo> saveAll(@RequestBody List<MovieInfo>movieList){
		return mvRepository.saveAll(movieList);	
	}
	
	@GetMapping("/movie-info/list")
	public List<MovieInfo> getAll(){
		return mvRepository.findAll();	
	}
	
	@GetMapping("/movie-info/find-path-by-id/{movieId}")
	public String findPathById(@PathVariable Long movieId) {
		var videoInfoOptional = mvRepository.findById(movieId);
		return videoInfoOptional.map(MovieInfo::getPath).orElse(null);
	}
}
