package com.springboot.backend.quileia.app.services;

import com.springboot.backend.quileia.app.entity.Usuario;

public interface UsuarioService {
	
	public Usuario findByUserAndPassword(String user, String password);
	public Usuario save(Usuario usuario);
}
