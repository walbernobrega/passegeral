package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.domain.PasseGeralId;

@Repository
public interface PasseGeralRepository extends JpaRepository<PasseGeral , PasseGeralId> {
	
	Page<PasseGeral> findByIdfilOrderByDataInclusao(PageRequest pageRequest, String idfil);
	
	List<PasseGeral> findByIdfilAndPortadorContainingIgnoreCaseOrderByPortador(String idfil, String portador);
	
}
