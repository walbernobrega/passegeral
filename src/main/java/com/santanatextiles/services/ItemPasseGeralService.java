package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.ItemPasseGeral;
import com.santanatextiles.domain.ItemPasseGeralId;
import com.santanatextiles.repositories.ItemPasseGeralRepository;

@Service
public class ItemPasseGeralService {

	@Autowired
	private ItemPasseGeralRepository repo;
	
	public ItemPasseGeral buscar(String numeroPasse, String codigoItem) {
		Optional<ItemPasseGeral> obj = repo.findById(new ItemPasseGeralId("01",numeroPasse, codigoItem));
		return obj.orElse(null);
	}
}
