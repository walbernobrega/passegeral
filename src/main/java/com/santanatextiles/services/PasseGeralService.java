package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.domain.PasseGeralId;
import com.santanatextiles.repositories.PasseGeralRepository;

@Service
public class PasseGeralService {

	@Autowired
	private PasseGeralRepository repo;
	
	public PasseGeral buscar(String numeroPasse) {
		Optional<PasseGeral> obj = repo.findById(new PasseGeralId("01",numeroPasse));
		return obj.orElse(null);
	}
}
