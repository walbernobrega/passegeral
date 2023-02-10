package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.Transportadora;
import com.santanatextiles.domain.TransportadoraId;
import com.santanatextiles.repositories.TransportadoraRepository;

@Service
public class TransportadoraService {

	@Autowired
	private TransportadoraRepository repo;
	
	public Transportadora buscar(String codigo) {
		Optional<Transportadora> obj = repo.findById(new TransportadoraId("01",codigo));
		return obj.orElse(null);
	}
}
