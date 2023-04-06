package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Gerente;
import com.santanatextiles.domain.GerenteId;
import com.santanatextiles.repositories.GerenteRepository;

@Service
public class GerenteService {

	@Autowired
	private GerenteRepository repo;
	
	public Gerente buscar(String idfil , String matricula) {
		Optional<Gerente> obj = repo.findById(new GerenteId(PassegeralApplication._EMPRESA,matricula));
		return obj.orElse(null);
	}
	
	public List<Gerente> listagemGeral(String idfil) {
		return repo.findByIdfilOrderByNome(idfil);
	}

	public List<Gerente> procuraPorNome(String idfil, String nome) {
		return repo.findByIdfilAndNomeContainingIgnoreCase(idfil, nome);
	}
	
	
}
