package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.domain.UsuarioPasseId;
import com.santanatextiles.repositories.UsuarioPasseRepository;

@Service
public class UsuarioPasseService {

	@Autowired
	private UsuarioPasseRepository repo;
	
	public UsuarioPasse buscar(String matricula) {
		Optional<UsuarioPasse> obj = repo.findById(new UsuarioPasseId("01",matricula));
		return obj.orElse(null);
	}
}
