package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	public Page<Transacao> listagemGeral(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfil(pageRequest,PassegeralApplication._EMPRESA);
	}

	public Page<Transacao> procuraPorDescricao(Integer page, Integer linesPerPage, String orderBy, String direction, String descricao) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfilAndDescricaoContainingIgnoreCase(pageRequest, PassegeralApplication._EMPRESA , descricao);
	}
	
}
