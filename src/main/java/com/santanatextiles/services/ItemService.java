package com.santanatextiles.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Item;
import com.santanatextiles.domain.ItemId;
import com.santanatextiles.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository repo;
	
	public Item buscar(Long codigo) {
		Optional<Item> obj = repo.findById(new ItemId(PassegeralApplication._LOCALIZACAO,codigo));
		return obj.orElse(null);
	}
	
	public List<Item> procuraPorDescricao(String descricao) {
		return repo.procuraPorDescricao(Long.valueOf(PassegeralApplication._EMPRESA), PassegeralApplication._LOCALIZACAO, descricao.toUpperCase());
	}
	
}
