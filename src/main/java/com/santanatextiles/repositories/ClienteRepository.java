package com.santanatextiles.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Cliente;
import com.santanatextiles.domain.ClienteId;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , ClienteId> {
	
	Page<Cliente> findByIdfil(PageRequest pageRequest, String idfil);
	
	Page<Cliente> findByIdfilAndDescricaoContainingIgnoreCase(PageRequest pageRequest, String idfil, String descricao);
	
}
