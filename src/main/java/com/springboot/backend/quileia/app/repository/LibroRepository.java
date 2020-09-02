package com.springboot.backend.quileia.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.quileia.app.entity.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long>{

	
}
