package com.example.codetest.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "movies")
public class Movies {

	@Id
	@Column(name = "tconst")
	private String tconst;
	@Column(name = "title_type")
	private String titleType;
	@Column(name = "primary_title")
	private String primaryTitle;
	@Column(name = "runtime_minutes")
	private int runtimeMinutes;
	@Column(name = "genres")
	private String genres;	

}
