package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Transacao;
import com.santanatextiles.domain.TransacaoId;
import com.santanatextiles.repositories.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repo;
	
	public Transacao buscar(String idfil , String codigo) {
		Optional<Transacao> obj = repo.findById(new TransacaoId(PassegeralApplication._EMPRESA,codigo));
		return obj.orElse(null);
	}
	
	public List<Transacao> listagemGeral(String idfil) {
		return repo.findByIdfilOrderByDescricao(idfil);
	}
	
	public List<Transacao> procuraPorDescricao(String idfil, String descricao) {
		return repo.findByIdfilAndDescricaoContainingIgnoreCaseOrderByDescricao(idfil, descricao);
	}
	
}
