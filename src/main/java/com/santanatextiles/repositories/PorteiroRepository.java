package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.domain.PorteiroId;

@Repository
public interface PorteiroRepository extends JpaRepository<Porteiro , PorteiroId> {
	
	List<Porteiro> findByIdfilOrderByNome(String idfil);
	
	List<Porteiro> findByIdfilAndNomeContainingIgnoreCaseOrderByNome(String idfil, String nome);
	
}
