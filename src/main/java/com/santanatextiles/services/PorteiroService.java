package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.domain.PorteiroId;
import com.santanatextiles.repositories.PorteiroRepository;

@Service
public class PorteiroService {

	@Autowired
	private PorteiroRepository repo;
	
	public Porteiro buscar(String idfil , String codigo) {
		Optional<Porteiro> obj = repo.findById(new PorteiroId(PassegeralApplication._EMPRESA,codigo));
		return obj.orElse(null);
	}
	
	public List<Porteiro> listagemGeral(String idfil) {
		return repo.findByIdfilOrderByNome(idfil);
	}
	
	public List<Porteiro> procuraPorNome(String idfil, String nome) {
		return repo.findByIdfilAndNomeContainingIgnoreCaseOrderByNome(idfil, nome);
	}
	
}
