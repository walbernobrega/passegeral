package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.ItemPasseGeral;
import com.santanatextiles.domain.ItemPasseGeralId;

@Repository
public interface ItemPasseGeralRepository extends JpaRepository<ItemPasseGeral , ItemPasseGeralId> {

}
