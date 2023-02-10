package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.Fornecedor;
import com.santanatextiles.domain.FornecedorId;
import com.santanatextiles.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repo;
	
	public Fornecedor buscar(String codigo) {
		Optional<Fornecedor> obj = repo.findById(new FornecedorId("01",codigo));
		return obj.orElse(null);
	}
}
