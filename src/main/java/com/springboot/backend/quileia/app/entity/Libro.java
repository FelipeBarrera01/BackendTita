package com.springboot.backend.quileia.app.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String autor;
	
	private String categoria;
	
	private int cantidad;
	
	@Column(name = "cantidad_disponible")
	private int cantidadDisponible;
	
	@Column(name = "cantidad_reservada")
	private int cantidadReservada;
	
	private int tarifa;
	






	public Long getId() {
		return id;
	}







	public void setId(Long id) {
		this.id = id;
	}







	public String getNombre() {
		return nombre;
	}







	public void setNombre(String nombre) {
		this.nombre = nombre;
	}







	public String getAutor() {
		return autor;
	}







	public void setAutor(String autor) {
		this.autor = autor;
	}







	public String getCategoria() {
		return categoria;
	}







	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}







	public int getCantidad() {
		return cantidad;
	}







	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}







	public int getCantidadDisponible() {
		return cantidadDisponible;
	}







	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}







	public int getCantidadReservada() {
		return cantidadReservada;
	}







	public void setCantidadReservada(int cantidadReservada) {
		this.cantidadReservada = cantidadReservada;
	}







	public int getTarifa() {
		return tarifa;
	}







	public void setTarifa(int tarifa) {
		this.tarifa = tarifa;
	}







	/**
	 * 
	 */
	private static final long serialVersionUID = 9007118754176987489L;

}
