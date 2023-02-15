package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Transportadora;
import com.santanatextiles.domain.TransportadoraId;
import com.santanatextiles.repositories.TransportadoraRepository;

@Service
public class TransportadoraService {

	@Autowired
	private TransportadoraRepository repo;
	
	public Transportadora buscar(String idfil , String codigo) {
		Optional<Transportadora> obj = repo.findById(new TransportadoraId(PassegeralApplication._EMPRESA,codigo));
		return obj.orElse(null);
	}
	
	public List<Transportadora> listagemGeral(String idfil) {
		return repo.findByIdfilOrderByDescricao(idfil);
	}
	
	public List<Transportadora> procuraPorDescricao(String idfil, String descricao) {
		return repo.findByIdfilAndDescricaoContainingIgnoreCaseOrderByDescricao(idfil, descricao);
	}
	
}
