package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.domain.PorteiroId;
import com.santanatextiles.repositories.PorteiroRepository;

@Service
public class PorteiroService {

	@Autowired
	private PorteiroRepository repo;
	
	public Porteiro buscar(String codigo) {
		Optional<Porteiro> obj = repo.findById(new PorteiroId("01",codigo));
		return obj.orElse(null);
	}
}
