package com.santanatextiles.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Fornecedor;
import com.santanatextiles.domain.FornecedorId;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor , FornecedorId> {
	
	Page<Fornecedor> findByIdfil(PageRequest pageRequest, String idfil);
	
	Page<Fornecedor> findByIdfilAndDescricaoContainingIgnoreCase(PageRequest pageRequest, String idfil, String descricao);
	
}
