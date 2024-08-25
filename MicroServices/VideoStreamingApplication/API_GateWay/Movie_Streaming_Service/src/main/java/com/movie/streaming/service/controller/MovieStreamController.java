package com.movie.streaming.service.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieStreamController {
	
	public static final String video_dir = "D://stream//";
	
	@Autowired
	private MovieCatlogService mcService;
	
	private static final Logger logger = Logger.getLogger(MovieStreamController.class.getName()); 

	@GetMapping("/stream/{videoPath}")
	public ResponseEntity<InputStreamResource> streamVideo(@PathVariable String videoPath) throws FileNotFoundException{
		File file = new File(video_dir + videoPath);
		if(file.exists()) {
			InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
			return ResponseEntity.ok()
			               .contentType(MediaType.parseMediaType("video/mp4"))
			               .body(resource);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/stream/with-id/{movieId}")
	public ResponseEntity<InputStreamResource> streamVideoById(@PathVariable Long movieId) throws FileNotFoundException{
		logger.info("video id : "+movieId);
		String moviePath = mcService.getMoviePath(movieId);
		logger.info("Movie Path : "+moviePath);
		return streamVideo(moviePath);
	}
	
	
}
