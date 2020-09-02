package com.springboot.backend.quileia.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "reservas")
public class Reserva implements Serializable{


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha_devolucion")
	private Date fechaDevolucion; 
	
	@OneToOne
	private Usuario usuario;
	
	@OneToOne
	private Libro libro;
	
	@Column(name = "cantidad_reservada")
	private int cantidadReservado;
	
	@Column(name = "total_reserva")
	private int totalReserva;
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}



	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Libro getLibro() {
		return libro;
	}



	public void setLibro(Libro libro) {
		this.libro = libro;
	}



	public int getCantidadReservado() {
		return cantidadReservado;
	}



	public void setCantidadReservado(int cantidadReservado) {
		this.cantidadReservado = cantidadReservado;
	}



	public int getTotalReserva() {
		return totalReserva;
	}



	public void setTotalReserva(int totalReserva) {
		this.totalReserva = totalReserva;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 157836532673735823L;
}
