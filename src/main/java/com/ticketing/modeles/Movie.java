package com.ticketing.modeles;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private int movieId;
	@NotNull
	private String movieName;
	@NotNull
	private String movieLanguage;
	@NotNull
	private String movieGenre;
	@NotNull
	private String duration;
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieLanguage() {
		return movieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Movie() {
	}
	public Movie(@NotNull String movieName, @NotNull String movieLanguage, @NotNull String movieGenre,
			@NotNull String duration) {
		this.movieName = movieName;
		this.movieLanguage = movieLanguage;
		this.movieGenre = movieGenre;
		this.duration = duration;
	}
	
	
}
