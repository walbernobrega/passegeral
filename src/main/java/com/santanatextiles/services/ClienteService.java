package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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

	public Page<Cliente> listagemGeral(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfil(pageRequest,PassegeralApplication._EMPRESA);
	}

	public Page<Cliente> procuraPorDescricao(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil, String descricao) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfilAndDescricaoContainingIgnoreCase(pageRequest, idfil, descricao);
	}
	
}
