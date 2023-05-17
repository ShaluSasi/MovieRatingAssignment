package com.onito.codetest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.onito.codetest.model.Movies;

import jakarta.transaction.Transactional;

public interface MovieRepo extends JpaRepository<Movies, String> {

	@Query(value = "SELECT tconst,primary_title,runtime_minutes,genres FROM movies ORDER BY runtime_minutes DESC LIMIT 10", nativeQuery = true)
	List<String> findTopTenLongestDurationMovies();

	@Modifying
	@Transactional
	@Query(value = "UPDATE movies SET runtime_minutes = runtime_minutes + CASE WHEN genres = 'Documentary' THEN 15 WHEN genres = 'Animation' THEN 30 ELSE 45 END", nativeQuery = true)
	void updateRuntimeMinutes();

}
