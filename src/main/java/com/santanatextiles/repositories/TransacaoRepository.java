package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Transacao;
import com.santanatextiles.domain.TransacaoId;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao , TransacaoId> {

}
