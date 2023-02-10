package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.Item;
import com.santanatextiles.domain.ItemId;
import com.santanatextiles.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repo;
	
	public Item buscar(Long codigo) {
		Optional<Item> obj = repo.findById(new ItemId(Long.parseLong("1"),codigo));
		return obj.orElse(null);
	}
}
