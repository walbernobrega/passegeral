package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.CentroDeCusto;
import com.santanatextiles.domain.CentroDeCustoId;
import com.santanatextiles.repositories.CentroDeCustoRepository;
import com.santanatextiles.services.exceptions.ObjectNotFoundException;

@Service
public class CentroDeCustoService {

	@Autowired
	private CentroDeCustoRepository repo;
	
	public CentroDeCusto buscar(String idfil , String codigo) {
		Optional<CentroDeCusto> obj = repo.findById(new CentroDeCustoId(PassegeralApplication._EMPRESA,codigo));
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException("Centro de Custo Não Encontrado");
		}
		return obj.orElse(null);
	}
	
	public Page<CentroDeCusto> listagemGeral(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfil(pageRequest,PassegeralApplication._EMPRESA);
	}

	public Page<CentroDeCusto> procuraPorDescricao(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil, String descricao) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfilAndDescricaoContainingIgnoreCase(pageRequest, idfil, descricao);
	}
	
}
