package com.santanatextiles.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Item;
import com.santanatextiles.domain.RetornoItemPasseGeral;
import com.santanatextiles.domain.RetornoItemPasseGeralId;
import com.santanatextiles.dto.RetornoItemPasseGeralDTO;
import com.santanatextiles.repositories.RetornoItemPasseGeralRepository;
import com.santanatextiles.services.exceptions.DataIntegrityException;

@Service
public class RetornoItemPasseGeralService {

	@Autowired
	private RetornoItemPasseGeralRepository repo;

	@Autowired
	private ItemService itemService;
	
	private ArrayList<String> msg = new ArrayList<>();
	
	public RetornoItemPasseGeral buscar(String idfil, String numeroPasse, String codigoItem) {
		Optional<RetornoItemPasseGeral> obj = repo.findByIdfilAndNumeroPasseAndCodigoItem(idfil,numeroPasse,codigoItem);
		return obj.orElse(null);
	}

	public RetornoItemPasseGeral buscarDataHora(String idfil, String numeroPasse, String codigoItem, Date data, String hora) {
		Optional<RetornoItemPasseGeral> obj = repo.findById(new RetornoItemPasseGeralId(idfil,numeroPasse,codigoItem,data,hora));
		return obj.orElse(null);
	}
	
	public RetornoItemPasseGeral insert(RetornoItemPasseGeral obj, String novoCodigo, String codigoItem, Date dataRetorno, String horaRetorno ) {
		
		obj.setIdfil(PassegeralApplication._EMPRESA);
		obj.setNumeroPasse(novoCodigo);
		obj.setCodigoItem(codigoItem);
		obj.setDataRetorno(dataRetorno);
		obj.setHoraRetorno(horaRetorno);
		
		return repo.save(obj);
	}
	
	public RetornoItemPasseGeral update(RetornoItemPasseGeral obj) {
		
		List<String> msg = verificaEntidades(obj);
		
		if (msg.isEmpty()) {
			buscarDataHora(PassegeralApplication._EMPRESA,obj.getNumeroPasse(), obj.getCodigoItem(), obj.getDataRetorno(), obj.getHoraRetorno());
		} else {
			throw new DataIntegrityException(String.join(",", msg)); 
		}
		
		return repo.save(obj);
		
	}

	public int deletaTodos(String idfil , String numeroPasse) {
		
		return repo.deletaTodos(idfil, numeroPasse);
		
	}
	
	public int deletaRetornoItem(String idfil , String numeroPasse , String codigoItem) {
		
		return repo.deletaRetornoItem(idfil, numeroPasse, codigoItem);
		
	}
	
	private List<String> verificaEntidades(RetornoItemPasseGeral obj) {
		this.msg.clear();
		try {
			if(obj.getCodigoItem() != null && ("111111|999999").indexOf(obj.getCodigoItem()) == -1) {
				Item item = itemService.buscar(Long.parseLong(obj.getCodigoItem()));
				obj.setItem(item);
/*				
				if ( item == null) {
					this.msg.add("Item Não Cadastrado");
				} else {
					obj.setItem(item);
				};
*/				
			}
		} 
		catch (Exception e) {
			
		}
		return this.msg;
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
		objDTO.getNotaVenda(),
		objDTO.getValorNotaVenda(),
		objDTO.getStatus(),
		objDTO.getValorRetorno(),
		objDTO.getPagamentoRetorno(),
		objDTO.getObservacao());
	}
	
}
