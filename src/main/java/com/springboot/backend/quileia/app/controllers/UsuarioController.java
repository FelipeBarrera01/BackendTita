package com.springboot.backend.quileia.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.backend.quileia.app.entity.Usuario;
import com.springboot.backend.quileia.app.services.UsuarioService;

@CrossOrigin(origins = { "http://localhost:8100" })
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	@GetMapping("/{usuario}/{password}")
	public ResponseEntity<?> findUserByUsuarioAndPassword(@PathVariable String usuario, @PathVariable String password){
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findByUserAndPassword(usuario, password));
	}
}
