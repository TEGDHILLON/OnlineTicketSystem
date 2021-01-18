package com.ticketing.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ticketing.modeles.Movie;
import com.ticketing.services.MovieService;

@Controller
@RequestMapping(path = "movies")
public class MovieController {

	@Autowired
	MovieService movieService;
	
		@GetMapping
		public String getAll(Model model) {
		        model.addAttribute("movies", movieService.getAllMovies());
		        return "all-movies";
		  
		}
	   @GetMapping("/addmovie")
	    public String showSignUpForm(Movie movie) {
	        return "add-movie";
	    }

	    @PostMapping("/addmovie")
	    public String addUser(@Valid Movie movie, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            return "add-movie";
	        }
	        movieService.addMovie(movie);
	        return "redirect:/movies";
	    }
	    @GetMapping("/edit/{id}")
	    public String showUpdateForm(@PathVariable("id") int id, Model model) {
	        Optional<Movie> movie = movieService.getMovie(id);
	        model.addAttribute("movie", movie.get());
	    
	        return "update-movie";
	    }
	    @PostMapping("/edit/{id}")
	    public String updateUser(@PathVariable("id") int id, @Valid Movie movie,
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            movie.setMovieId(id);
	            return "update-movie";
	        }
	        movieService.updateMovie(id, movie);
	        return "redirect:/movies";
	    }
	    @GetMapping("/delete/{id}")
	    public String deleteUser(@PathVariable("id") int id, Model model) {
	       movieService.deleteMovie(id);
	       return "redirect:/movies";
	    }
}
