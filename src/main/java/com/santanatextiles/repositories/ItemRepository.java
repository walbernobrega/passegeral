package com.santanatextiles.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Item;
import com.santanatextiles.domain.ItemId;

@Repository
public interface ItemRepository extends JpaRepository<Item , ItemId> {
	
	Page<Item> findByLocalizacao(PageRequest pageRequest, Long localizacao);
	
	@Query(value="SELECT i "
			+ "FROM Item i "
			+ "WHERE i.localizacao = :localizacao "
			+ "AND i.idfil = :idfil "
			+ "AND UPPER(i.material.descricao) LIKE %:descricao% "
			+ "ORDER BY i.material.descricao")
	List<Item> procuraPorDescricao(Long localizacao , Long idfil,  String descricao);

}
