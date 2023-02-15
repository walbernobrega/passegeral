package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Cliente;
import com.santanatextiles.domain.ClienteId;
import com.santanatextiles.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(String idfil , String codigo) {
		Optional<Cliente> obj = repo.findById(new ClienteId(PassegeralApplication._EMPRESA,codigo));
		return obj.orElse(null);
	}
	
	public List<Cliente> listagemGeral(String idfil) {
		return repo.findByIdfilOrderByDescricao(idfil);
	}
	
	public List<Cliente> procuraPorDescricao(String idfil, String descricao) {
		return repo.findByIdfilAndDescricaoContainingIgnoreCaseOrderByDescricao(idfil, descricao);
	}
	
}
