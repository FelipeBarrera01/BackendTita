package com.springboot.backend.quileia.app.services;

import java.util.List;

import com.springboot.backend.quileia.app.entity.Libro;

public interface LibroService {

 public List<Libro> findAll();
 public Libro save(Libro libro);
 public Libro findById(Long id);
 public void deleteById(Long id);
}
