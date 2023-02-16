package com.santanatextiles.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.domain.PorteiroId;

@Repository
public interface PorteiroRepository extends JpaRepository<Porteiro , PorteiroId> {
	
	Page<Porteiro> findByIdfil(PageRequest pageRequest, String idfil);
	
	Page<Porteiro> findByIdfilAndNomeContainingIgnoreCase(PageRequest pageRequest, String idfil, String nome);
	
}
