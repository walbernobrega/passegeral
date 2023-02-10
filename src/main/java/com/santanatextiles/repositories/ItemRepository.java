package com.santanatextiles.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.santanatextiles.domain.Item;
import com.santanatextiles.domain.ItemId;

@Repository
public interface ItemRepository extends JpaRepository<Item , ItemId> {

}
