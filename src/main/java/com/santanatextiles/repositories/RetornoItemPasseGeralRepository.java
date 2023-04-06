package com.santanatextiles.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.domain.RetornoItemPasseGeral;
import com.santanatextiles.domain.RetornoItemPasseGeralId;

@Repository
public interface RetornoItemPasseGeralRepository extends JpaRepository<RetornoItemPasseGeral , RetornoItemPasseGeralId> {

	@Transactional(readOnly=true)
	Optional<RetornoItemPasseGeral> findByIdfilAndNumeroPasseAndCodigoItem(String idfil, String numeroPasse, String codigoItem);
	
	@Modifying
	@Query(value="DELETE FROM bal.balj2_dbf "
			+ "WHERE idfil = :idfil "
			+ "AND j2cod = :numeroPasse ", nativeQuery = true)
	int deletaTodos(
			@Param("idfil") String idfil,
			@Param("numeroPasse") String numeroPasse);
	
	@Modifying
	@Query(value="DELETE FROM bal.balj2_dbf "
			+ "WHERE idfil = :idfil "
			+ "AND j2cod = :numeroPasse "
			+ "AND j2item = :codigoItem ", nativeQuery = true)
	int deletaRetornoItem(
			@Param("idfil") String idfil,
			@Param("numeroPasse") String numeroPasse,
			@Param("codigoItem") String codigoItem);
	

}
