package com.movie.streaming.service.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


@Component
@FeignClient(name = "movie-catalog-service", url = "http://localhost:8090")
public interface MovieCatlogService {
	
	//private static final String catlog_Service ="http://Movie_Catlog_Service"; //localhost:8090/movie-info/find-path-by-id/1
	
	//private static final Logger logger = Logger.getLogger(MovieCatlogService.class.getName()); 

	//@Autowired
	//private RestTemplate restTemplate;
	
    /*public String getMoviePath(Long movieId) {
    	logger.info("Movie Id : "+movieId);
		var response = restTemplate.getForEntity(catlog_Service + "/movie-info/find-path-by-id/{movieId}", String.class, movieId);
		return response.getBody();
	}*/
	
	  @GetMapping("/movie-info/find-path-by-id/{movieId}")
	  String getMoviePath(@PathVariable("movieId") Long movieId);
	

}
