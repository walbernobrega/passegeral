package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Fornecedor;
import com.santanatextiles.domain.FornecedorId;
import com.santanatextiles.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repo;
	
	public Fornecedor buscar(String idfil , String codigo) {
		Optional<Fornecedor> obj = repo.findById(new FornecedorId(PassegeralApplication._EMPRESA,codigo));
		return obj.orElse(null);
	}
	
	public List<Fornecedor> listagemGeral(String idfil) {
		return repo.findByIdfilOrderByDescricao(idfil);
	}
	
	public List<Fornecedor> procuraPorDescricao(String idfil, String descricao) {
		return repo.findByIdfilAndDescricaoContainingIgnoreCaseOrderByDescricao(idfil, descricao);
	}
	
}
