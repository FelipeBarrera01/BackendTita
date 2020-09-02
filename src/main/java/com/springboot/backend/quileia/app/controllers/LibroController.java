package com.springboot.backend.quileia.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.quileia.app.entity.Libro;
import com.springboot.backend.quileia.app.services.LibroService;

@CrossOrigin(origins = { "http://localhost:8100" })
@RestController
@RequestMapping("/libro")
public class LibroController {

	@Autowired
	private LibroService libroService;

	@GetMapping
	public ResponseEntity<?> findAll() {
		return ResponseEntity.ok().body(libroService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return ResponseEntity.ok().body(libroService.findById(id));
	}
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Libro libro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(libroService.save(libro));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Libro libro, @PathVariable Long id) {

		Libro libroDB = libroService.findById(id);
		
		if(libro.getCantidad() > libroDB.getCantidad()) {
			libroDB.setCantidad(libro.getCantidad());
			//libroDB.setCantidadDisponible(libroDB.getCantidadDisponible() + (libro.getCantidad() - libroDB.getCantidad()));
			libroDB.setCantidadDisponible(libro.getCantidad()- libroDB.getCantidadReservada());
		}
		
		if(libro.getCantidad() < libroDB.getCantidad()) {
			if(libro.getCantidad() < libroDB.getCantidadReservada()) {
				String response = "La cantidad en inventario no puede ser menor a la cantidad reservada";
				return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			libroDB.setCantidad(libro.getCantidad());
			libroDB.setCantidadDisponible(libroDB.getCantidadDisponible() - ( libroDB.getCantidad() - libro.getCantidad() ));
		}
		
		libroDB.setTarifa(libro.getTarifa());
		return ResponseEntity.status(HttpStatus.CREATED).body(libroService.save(libroDB));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id ){
		libroService.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
