package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.domain.UsuarioPasseId;

@Repository
public interface UsuarioPasseRepository extends JpaRepository<UsuarioPasse , UsuarioPasseId> {
	
	List<UsuarioPasse> findByIdfilOrderByNome(String idfil);
	
	List<UsuarioPasse> findByIdfilAndNomeContainingIgnoreCaseOrderByNome(String idfil, String nome);
	
}
