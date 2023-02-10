package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.domain.PasseGeralId;

@Repository
public interface PasseGeralRepository extends JpaRepository<PasseGeral , PasseGeralId> {

}
