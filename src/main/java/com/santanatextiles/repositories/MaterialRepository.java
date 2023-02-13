package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Material;
import com.santanatextiles.domain.MaterialId;

@Repository
public interface MaterialRepository extends JpaRepository<Material , MaterialId> {

}
