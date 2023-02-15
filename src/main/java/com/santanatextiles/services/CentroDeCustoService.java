package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.CentroDeCusto;
import com.santanatextiles.domain.CentroDeCustoId;
import com.santanatextiles.repositories.CentroDeCustoRepository;

@Service
public class CentroDeCustoService {

	@Autowired
	private CentroDeCustoRepository repo;
	
	public CentroDeCusto buscar(String idfil , String codigo) {
		Optional<CentroDeCusto> obj = repo.findById(new CentroDeCustoId(PassegeralApplication._EMPRESA,codigo));
		return obj.orElse(null);
	}
	
	public List<CentroDeCusto> listagemGeral(String idfil) {
		return repo.findByIdfilOrderByDescricao(idfil);
	}
	
	public List<CentroDeCusto> procuraPorDescricao(String idfil, String descricao) {
		return repo.findByIdfilAndDescricaoContainingIgnoreCaseOrderByDescricao(idfil, descricao);
	}
	
}
