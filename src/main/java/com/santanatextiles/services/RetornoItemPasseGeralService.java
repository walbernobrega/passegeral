package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.RetornoItemPasseGeral;
import com.santanatextiles.domain.RetornoItemPasseGeralId;
import com.santanatextiles.repositories.RetornoItemPasseGeralRepository;

@Service
public class RetornoItemPasseGeralService {

	@Autowired
	private RetornoItemPasseGeralRepository repo;
	
	public RetornoItemPasseGeral buscar(String numeroPasse, String codigoItem) {
		Optional<RetornoItemPasseGeral> obj = repo.findById(new RetornoItemPasseGeralId("01",numeroPasse,codigoItem));
		return obj.orElse(null);
	}
}
