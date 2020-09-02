package com.springboot.backend.quileia.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.quileia.app.entity.Libro;
import com.springboot.backend.quileia.app.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService{

	@Autowired LibroRepository libroRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Libro> findAll() {
		return (List<Libro>) libroRepository.findAll();
	}

	@Override
	@Transactional
	public Libro save(Libro libro) {
		return libroRepository.save(libro);
	}

	@Override
	@Transactional(readOnly = true)
	public Libro findById(Long id) {
		return libroRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		libroRepository.deleteById(id);
		
	}
}
