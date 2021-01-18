package com.ticketing.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticketing.modeles.Customer;
import com.ticketing.modeles.Movie;
import com.ticketing.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	public List<Movie> getAllMovies(){
		List<Movie> Movies=new ArrayList<>();
		movieRepository.findAll().forEach(Movies::add);
	return Movies;
	}
	 public void addMovie(Movie Movie) {
		 movieRepository.save(Movie);
	 }
	public Optional<Movie> getMovie(int id) {
			Optional<Movie> m=movieRepository.findById(id);
			return m;
		}
	 public void updateMovie(int id, Movie movie) {
		 movie.setMovieId(id);
		 movieRepository.save(movie);
		}
		
	 public void deleteMovie(Integer id) {
			movieRepository.deleteById(id);
			
		}
}
