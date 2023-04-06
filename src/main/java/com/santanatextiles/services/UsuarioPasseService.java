package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.domain.UsuarioPasseId;
import com.santanatextiles.repositories.UsuarioPasseRepository;

@Service
public class UsuarioPasseService {

	@Autowired
	private UsuarioPasseRepository repo;
	
	public UsuarioPasse buscar(String idfil , String matricula) {
		Optional<UsuarioPasse> obj = repo.findById(new UsuarioPasseId(PassegeralApplication._EMPRESA,matricula));
		return obj.orElse(null);
	}
	
	public Page<UsuarioPasse> listagemGeral(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfil(pageRequest,PassegeralApplication._EMPRESA);
	}

	public List<UsuarioPasse> procuraPorNome(String idfil, String nome) {
		return repo.findByIdfilAndNomeContainingIgnoreCase(idfil, nome);
	}
}
