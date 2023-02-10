package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.CentroDeCusto;
import com.santanatextiles.domain.CentroDeCustoId;
import com.santanatextiles.repositories.CentroDeCustoRepository;

@Service
public class CentroDeCustoService {

	@Autowired
	private CentroDeCustoRepository repo;
	
	public CentroDeCusto buscar(String codigo) {
		Optional<CentroDeCusto> obj = repo.findById(new CentroDeCustoId("01",codigo));
		return obj.orElse(null);
	}
}
