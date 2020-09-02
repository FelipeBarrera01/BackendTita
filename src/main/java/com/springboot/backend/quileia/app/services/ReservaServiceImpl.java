package com.springboot.backend.quileia.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.backend.quileia.app.entity.Reserva;
import com.springboot.backend.quileia.app.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaRepository reservaRepository;
	
	@Override
	@Transactional
	public Reserva save(Reserva reserva) {
		return reservaRepository.save(reserva);
	}

}
