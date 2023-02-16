package com.santanatextiles.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.domain.UsuarioPasseId;

@Repository
public interface UsuarioPasseRepository extends JpaRepository<UsuarioPasse , UsuarioPasseId> {
	
	Page<UsuarioPasse> findByIdfil(PageRequest pageRequest, String idfil);
	
	Page<UsuarioPasse> findByIdfilAndNomeContainingIgnoreCase(PageRequest pageRequest, String idfil, String nome);
	
}
