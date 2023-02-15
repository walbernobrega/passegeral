package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public List<UsuarioPasse> listagemGeral(String idfil) {
		return repo.findByIdfilOrderByNome(idfil);
	}
	
	public List<UsuarioPasse> procuraPorNome(String idfil, String nome) {
		return repo.findByIdfilAndNomeContainingIgnoreCaseOrderByNome(idfil, nome);
	}
	
}
