package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.Cliente;
import com.santanatextiles.domain.ClienteId;
import com.santanatextiles.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(String codigo) {
		Optional<Cliente> obj = repo.findById(new ClienteId("01",codigo));
		return obj.orElse(null);
	}
}
