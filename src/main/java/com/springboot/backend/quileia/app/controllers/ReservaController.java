package com.springboot.backend.quileia.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.quileia.app.entity.Libro;
import com.springboot.backend.quileia.app.entity.Reserva;
import com.springboot.backend.quileia.app.services.LibroService;
import com.springboot.backend.quileia.app.services.ReservaService;

@CrossOrigin(origins = { "http://localhost:8100" })
@RestController
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	private LibroService libroService;
	
	@Autowired
	private ReservaService reservaService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Reserva reserva){
		
		if(reserva.getCantidadReservado() > reserva.getLibro().getCantidadDisponible()) {
			String response = "La cantidad del libro reservado supera la cantidad disponible";
			return new ResponseEntity<Object>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		Libro libroAux = reserva.getLibro();
		
		libroAux.setCantidadDisponible
		(reserva.getLibro().getCantidadDisponible() - reserva.getCantidadReservado());
		
		
		
		reserva.setLibro(libroService.save(libroAux));

	
		return ResponseEntity.status(HttpStatus.CREATED).body(reservaService.save(reserva));
	}
}
