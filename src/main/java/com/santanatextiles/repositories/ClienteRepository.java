package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Cliente;
import com.santanatextiles.domain.ClienteId;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente , ClienteId> {

}
