package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	
	public Page<Porteiro> listagemGeral(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfil(pageRequest,PassegeralApplication._EMPRESA);
	}

	public Page<Porteiro> procuraPorNome(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil, String nome) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfilAndNomeContainingIgnoreCase(pageRequest, idfil, nome);
	}
	
	
}
