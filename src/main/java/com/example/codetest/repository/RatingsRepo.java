package com.example.codetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.codetest.model.Ratings;

public interface RatingsRepo extends JpaRepository<Ratings, String>{

	@Query(value = "SELECT r.tconst,primary_title,genres,average_rating FROM ratings r JOIN movies m ON r.tconst=m.tconst AND r.average_rating > 6.0 ORDER BY average_rating",nativeQuery = true)	
	List<String> getTopRatedMovies();

	@Query(value = "SELECT genres,primary_title,num_votes FROM movies m JOIN ratings r ON m.tconst=r.tconst ORDER BY m.genres",nativeQuery = true)
	List<String> getMoviesListByGenre();

	@Query(value = "SELECT genres,SUM(num_votes) FROM movies m JOIN ratings r ON m.tconst=r.tconst GROUP BY m.genres",nativeQuery = true)	
	List<String> getSumOfNumVotesGroupByGenre();

	
}
