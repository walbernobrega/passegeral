package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Transportadora;
import com.santanatextiles.domain.TransportadoraId;

@Repository
public interface TransportadoraRepository extends JpaRepository<Transportadora , TransportadoraId> {

}
