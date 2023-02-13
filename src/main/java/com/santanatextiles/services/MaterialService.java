package com.santanatextiles.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.domain.Material;
import com.santanatextiles.domain.MaterialId;
import com.santanatextiles.repositories.MaterialRepository;

@Service
public class MaterialService {

	@Autowired
	private MaterialRepository repo;
	
	public Material buscar(Long codigo) {
		Optional<Material> obj = repo.findById(new MaterialId(Long.parseLong("1"),codigo));
		return obj.orElse(null);
	}
}
