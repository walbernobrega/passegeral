package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.domain.ItemPasseGeral;
import com.santanatextiles.domain.ItemPasseGeralId;

@Repository
public interface ItemPasseGeralRepository extends JpaRepository<ItemPasseGeral , ItemPasseGeralId> {
	
	@Modifying
	@Query(value="UPDATE bal.balj1_dbf SET "
			+ "J1PRUN=:valor "
			+ "WHERE idfil = :idfil "
			+ "AND j1cod = :numeroPasse "
			+ "AND j1item = :codigoItem", nativeQuery = true)
	int lancaValorItemPasseGeral(
			@Param("idfil") String idfil,
			@Param("numeroPasse") String numeroPasse,
			@Param("codigoItem") String codigoItem,
			@Param("valor") Float valor);
	
	@Transactional(readOnly=true)
	@Query(value="SELECT  NVL(SUM(j2.j2qtde),0) as qtderetornada"
			+ "     FROM  bal.balj2_dbf j2 "
			+ "    WHERE  j2.idfil = :idfil "
			+ "           AND j2.j2cod = :numeroPasse "
			+ "           AND j2.j2item = :codigoItem ", nativeQuery = true)
	Float atualizaSaldoItem(
			@Param("idfil") String idfil,
			@Param("numeroPasse") String numeroPasse,
			@Param("codigoItem") String codigoItem);
	

}
