package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.CentroDeCusto;
import com.santanatextiles.domain.CentroDeCustoId;

@Repository
public interface CentroDeCustoRepository extends JpaRepository<CentroDeCusto , CentroDeCustoId> {
	
	Page<CentroDeCusto> findByIdfil(PageRequest pageRequest, String idfil);
	
	List<CentroDeCusto> findByIdfilAndDescricaoContainingIgnoreCaseOrderByDescricao(String idfil, String descricao);
	
}
