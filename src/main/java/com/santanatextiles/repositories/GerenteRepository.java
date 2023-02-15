package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Gerente;
import com.santanatextiles.domain.GerenteId;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente , GerenteId> {
	
	List<Gerente> findByIdfilOrderByNome(String idfil);
	
	List<Gerente> findByIdfilAndNomeContainingIgnoreCaseOrderByNome(String idfil, String nome);
	
}
