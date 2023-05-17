package com.onito.codetest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onito.codetest.model.Movies;
import com.onito.codetest.repository.MovieRepo;

@RestController
public class MovieController {

	@Autowired
	private MovieRepo movieRepo;

	@GetMapping("/longest-duration-movies")
	public List<String> getLongestDurationMovies() {
		return movieRepo.findTopTenLongestDurationMovies();
	}

	@PostMapping("/new-movie")
	public String createMovie(@RequestBody Movies movie) {
		Movies result = movieRepo.save(movie);
		if (result == null) {
			return "Failed";
		}
		return "Success";

	}

	@PostMapping("/update-runtime-minutes")
	public void updateRuntimeMinutes() {
		movieRepo.updateRuntimeMinutes();
	}
}
