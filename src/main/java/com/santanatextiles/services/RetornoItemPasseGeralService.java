package com.santanatextiles.services;

import java.util.Date;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.RetornoItemPasseGeral;
import com.santanatextiles.domain.RetornoItemPasseGeralId;
import com.santanatextiles.dto.RetornoItemPasseGeralDTO;
import com.santanatextiles.repositories.RetornoItemPasseGeralRepository;

@Service
public class RetornoItemPasseGeralService {

	@Autowired
	private RetornoItemPasseGeralRepository repo;
	
	public RetornoItemPasseGeral buscar(String numeroPasse, String codigoItem) {
		Optional<RetornoItemPasseGeral> obj = repo.findById(new RetornoItemPasseGeralId("01",numeroPasse,codigoItem));
		return obj.orElse(null);
	}

	public RetornoItemPasseGeral insert(RetornoItemPasseGeral obj, String novoCodigo, String codigoItem, Date dataRetorno, String horaRetorno ) {
		
		obj.setIdfil(PassegeralApplication._EMPRESA);
		obj.setNumeroPasse(novoCodigo);
		obj.setDataRetorno(dataRetorno);
		obj.setHoraRetorno(horaRetorno);
		
		return repo.save(obj);
	}
	
	public RetornoItemPasseGeral fromDTO(RetornoItemPasseGeralDTO objDTO) {
		return new RetornoItemPasseGeral(
		objDTO.getIdfil(),
		objDTO.getNumeroPasse(),
		objDTO.getCodigoItem(),
		objDTO.getDataRetorno(),
		objDTO.getHoraRetorno(),
		objDTO.getCodigoPorteiro(),
		objDTO.getQtdeRetornada(),
		objDTO.getNotaFiscal(),
		objDTO.getNotaServico(),
		objDTO.getStatus(),
		objDTO.getPagamentoRetorno(),
		objDTO.getObservacao());
	}
	
}
