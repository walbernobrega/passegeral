package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.FornecedorCliente;
import com.santanatextiles.domain.FornecedorClienteId;

@Repository
public interface FornecedorClienteRepository extends JpaRepository<FornecedorCliente , FornecedorClienteId> {
	
	Page<FornecedorCliente> findByIdfil(PageRequest pageRequest, String idfil);
	
	List<FornecedorCliente> findByIdfilAndNomeContainingIgnoreCaseOrderByNome(String idfil, String descricao);
	
}
