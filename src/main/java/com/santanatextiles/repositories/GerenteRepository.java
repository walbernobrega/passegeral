package com.santanatextiles.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Gerente;
import com.santanatextiles.domain.GerenteId;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente , GerenteId> {
	
	Page<Gerente> findByIdfil(PageRequest pageRequest, String idfil);
	
	Page<Gerente> findByIdfilAndNomeContainingIgnoreCase(PageRequest pageRequest, String idfil, String nome);
	
}
