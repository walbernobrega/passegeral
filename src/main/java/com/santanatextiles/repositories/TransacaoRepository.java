package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Transacao;
import com.santanatextiles.domain.TransacaoId;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao , TransacaoId> {
	
	Page<Transacao> findByIdfil(PageRequest pageRequest, String idfil);
	
	List<Transacao> findByIdfilAndDescricaoContainingIgnoreCaseOrderByDescricao(String idfil , String descricao);
	
}
