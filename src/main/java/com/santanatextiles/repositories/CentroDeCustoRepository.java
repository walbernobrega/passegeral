package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.CentroDeCusto;
import com.santanatextiles.domain.CentroDeCustoId;

@Repository
public interface CentroDeCustoRepository extends JpaRepository<CentroDeCusto , CentroDeCustoId> {

}
