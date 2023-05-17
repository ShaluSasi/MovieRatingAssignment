package com.example.codetest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Ratings {

	@Id
	@Column(name = "tconst")
	private String tconst;
	@Column(name = "average_rating")
	private float averageRating;
	@Column(name = "num_votes")
	private int numVotes;
}
