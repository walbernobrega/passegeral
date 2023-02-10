package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.Gerente;
import com.santanatextiles.domain.GerenteId;
import com.santanatextiles.repositories.GerenteRepository;

@Service
public class GerenteService {

	@Autowired
	private GerenteRepository repo;
	
	public Gerente buscar(String matricula) {
		Optional<Gerente> obj = repo.findById(new GerenteId("01",matricula));
		return obj.orElse(null);
	}
}
