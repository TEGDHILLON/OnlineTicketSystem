package com.ticketing.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketing.modeles.Movie;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
