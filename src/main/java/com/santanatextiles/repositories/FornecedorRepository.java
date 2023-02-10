package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Fornecedor;
import com.santanatextiles.domain.FornecedorId;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor , FornecedorId> {

}
