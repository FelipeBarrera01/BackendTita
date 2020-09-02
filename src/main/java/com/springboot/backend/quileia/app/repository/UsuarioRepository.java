package com.springboot.backend.quileia.app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.springboot.backend.quileia.app.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query("select u from Usuario u where u.usuario = ?1 and u.contrasena = ?2")
	public Usuario findByUserAndPassword(String user, String password);
}
