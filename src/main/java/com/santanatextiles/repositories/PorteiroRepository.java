package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.domain.PorteiroId;

@Repository
public interface PorteiroRepository extends JpaRepository<Porteiro , PorteiroId> {
	
	Page<Porteiro> findByIdfil(PageRequest pageRequest, String idfil);
	
	List<Porteiro> findByIdfilAndNomeContainingIgnoreCase(String idfil, String nome);
	
}
