package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.Transacao;
import com.santanatextiles.domain.TransacaoId;
import com.santanatextiles.repositories.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repo;
	
	public Transacao buscar(String codigo) {
		Optional<Transacao> obj = repo.findById(new TransacaoId("01",codigo));
		return obj.orElse(null);
	}
}
