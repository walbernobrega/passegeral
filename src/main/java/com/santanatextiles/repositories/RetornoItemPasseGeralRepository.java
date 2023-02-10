package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.RetornoItemPasseGeral;
import com.santanatextiles.domain.RetornoItemPasseGeralId;

@Repository
public interface RetornoItemPasseGeralRepository extends JpaRepository<RetornoItemPasseGeral , RetornoItemPasseGeralId> {

}
