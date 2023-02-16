package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Gerente;
import com.santanatextiles.domain.GerenteId;
import com.santanatextiles.repositories.GerenteRepository;

@Service
public class GerenteService {

	@Autowired
	private GerenteRepository repo;
	
	public Gerente buscar(String idfil , String matricula) {
		Optional<Gerente> obj = repo.findById(new GerenteId(PassegeralApplication._EMPRESA,matricula));
		return obj.orElse(null);
	}
	
	public Page<Gerente> listagemGeral(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfil(pageRequest,PassegeralApplication._EMPRESA);
	}

	public Page<Gerente> procuraPorNome(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil, String nome) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfilAndNomeContainingIgnoreCase(pageRequest, idfil, nome);
	}
	
	
}
