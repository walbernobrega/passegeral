package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.FornecedorCliente;
import com.santanatextiles.domain.FornecedorClienteId;
import com.santanatextiles.repositories.FornecedorClienteRepository;
import com.santanatextiles.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorClienteService {

	@Autowired
	private FornecedorClienteRepository repo;
	
	public FornecedorCliente buscar(String idfil , String entidade , String codigo) {
		Optional<FornecedorCliente> obj = repo.findById(new FornecedorClienteId(PassegeralApplication._EMPRESA,entidade,codigo));
		if (obj.isEmpty()) {
			throw new ObjectNotFoundException("Fornecedor/Cliente Não Encontrado");
		}
		return obj.orElse(null);
	}
	
	public Page<FornecedorCliente> listagemGeral(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfil(pageRequest,PassegeralApplication._EMPRESA);
	}

	public List<FornecedorCliente> procuraPorNome(String idfil, String nome) {
		return repo.findByIdfilAndNomeContainingIgnoreCaseOrderByNome(idfil, nome);
	}
	
}
