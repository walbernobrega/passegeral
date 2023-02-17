package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.domain.PasseGeralId;
import com.santanatextiles.repositories.PasseGeralRepository;

@Service
public class PasseGeralService {

	@Autowired
	private PasseGeralRepository repo;
	
	public PasseGeral buscar(String idfil , String numeroPasse) {
		Optional<PasseGeral> obj = repo.findById(new PasseGeralId(PassegeralApplication._EMPRESA,numeroPasse));
		return obj.orElse(null);
	}
	
	public Page<PasseGeral> listagemGeral(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfilOrderByDataInclusao(pageRequest,PassegeralApplication._EMPRESA);
	}
	
	public List<PasseGeral> procuraPorPortador(String idfil, String portador) {
		return repo.findByIdfilAndPortadorContainingIgnoreCaseOrderByPortador(idfil, portador);
	}

	public Page<PasseGeral> passesNaoVerificados(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.passesNaoVerificados(pageRequest, idfil);
	}
	
	public Page<PasseGeral> passesNaoAprovados(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil, String gerente) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.passesNaoAprovados(pageRequest, idfil, gerente);
	}

	public Page<PasseGeral> passesDoUsuario(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil, String autor) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.passesDoUsuario(pageRequest, idfil, autor);
	}
	
}
