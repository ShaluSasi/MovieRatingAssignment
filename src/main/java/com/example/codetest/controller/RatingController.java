package com.example.codetest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codetest.repository.RatingsRepo;

@RestController
public class RatingController {

	@Autowired
	private RatingsRepo ratingRepo;

	@GetMapping("/top-rated-movies")
	public List<String> getTopRatedMovies() {
		return ratingRepo.getTopRatedMovies();
	}

	@GetMapping("/genre-movies-with-subtotals")
	public List<String> getGenreMoviesWithSubtotals() {
		List<String> movieList;
		List<String> sumList;
		List<String> concatenatedList;

		movieList = ratingRepo.getMoviesListByGenre();
		sumList = ratingRepo.getSumOfNumVotesGroupByGenre();
		concatenatedList = createList(movieList, sumList);

		return concatenatedList;
	}

	private List<String> createList(List<String> movieList, List<String> sumList) {
		List<String> concatenatedList = new ArrayList<String>();

		for (String sumStr : sumList) {
			String[] strArray = sumStr.split(",");
			String genre = strArray[0];
			List<String> movieListByGenre = getMovieListByGenre(genre, movieList);
			sumStr = sumStr.replace(genre, "TOTAL");
			concatenatedList.addAll(movieListByGenre);
			concatenatedList.add(sumStr);
		}
		return concatenatedList;

	}

	private List<String> getMovieListByGenre(String aGenre, List<String> movieList) {
		List<String> movieListForGenre = new ArrayList<String>();
		for (String str : movieList) {
			String[] strArray = str.split(",");
			String genre = strArray[0];
			if (genre.equals(aGenre)) {
				movieListForGenre.add(str);
			}
		}
		return movieListForGenre;
	}
}
