package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Fornecedor;
import com.santanatextiles.domain.FornecedorId;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor , FornecedorId> {
	
	List<Fornecedor> findByIdfilOrderByDescricao(String idfil);
	
	List<Fornecedor> findByIdfilAndDescricaoContainingIgnoreCaseOrderByDescricao(String idfil, String descricao);
	
}
