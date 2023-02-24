package com.santanatextiles.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Item;
import com.santanatextiles.domain.ItemPasseGeral;
import com.santanatextiles.domain.ItemPasseGeralId;
import com.santanatextiles.domain.RetornoItemPasseGeral;
import com.santanatextiles.dto.ItemPasseGeralDTO;
import com.santanatextiles.dto.RetornoItemPasseGeralDTO;
import com.santanatextiles.repositories.ItemPasseGeralRepository;
import com.santanatextiles.services.exceptions.DataIntegrityException;

@Service
public class ItemPasseGeralService {

	@Autowired
	private ItemPasseGeralRepository repo;

	@Autowired
	private ItemService itemService;

	@Autowired
	private RetornoItemPasseGeralService retornoItemPasseGeralService;
	
	private ArrayList<String> msg = new ArrayList<>();
	
	public ItemPasseGeral buscar(String idfil , String numeroPasse, String codigoItem) {
		Optional<ItemPasseGeral> obj = repo.findById(new ItemPasseGeralId(idfil,numeroPasse, codigoItem));
		return obj.orElse(null);
	}
	
	public ItemPasseGeral insert(ItemPasseGeral obj, String novoCodigo) {
		
		List<String> msg = verificaEntidades(obj);
		
		if (!msg.isEmpty()) {
			throw new DataIntegrityException(String.join(",", msg)); 
		}
		
		obj.setIdfil(PassegeralApplication._EMPRESA);
		obj.setNumeroPasse(novoCodigo);
		
		Iterator<RetornoItemPasseGeralDTO> it = obj.getRetornoItensPasseDTO().iterator();
		
		while (it.hasNext()) {
			RetornoItemPasseGeral retornoItemPasseGeral = retornoItemPasseGeralService.fromDTO(it.next());
			retornoItemPasseGeralService.insert(
					retornoItemPasseGeral, 
					novoCodigo, 
					retornoItemPasseGeral.getCodigoItem(),
					retornoItemPasseGeral.getDataRetorno(),
					retornoItemPasseGeral.getHoraRetorno()
					);
		}
		
		return repo.save(obj);
	}

	public ItemPasseGeral update(ItemPasseGeral obj) {
		List<String> msg = verificaEntidades(obj);
		if (msg.isEmpty()) {
			buscar(PassegeralApplication._EMPRESA,obj.getNumeroPasse(), obj.getCdItem());
		} else {
			throw new DataIntegrityException(String.join(",", msg)); 
		}
		return repo.save(obj);
		
	}
	
	private List<String> verificaEntidades(ItemPasseGeral obj) {
		this.msg.clear();
		try {
			if(obj.getCdItem() != null && ("111111|999999").indexOf(obj.getCdItem()) == -1) {
				Item item = itemService.buscar(Long.parseLong(obj.getCdItem())); 
				if ( item == null) {
					this.msg.add("Item Não Cadastrado");
				} else {
					obj.setItem(item);
				};
			}
		} 
		catch (Exception e) {
			
		}
		return this.msg;
	}
	
	@Transactional
	public ItemPasseGeral lancaValorItemPasseGeral(
			String numeroPasse,
			String codigoItem,
			Float valor) {
		
		this.msg.clear();
		
		if (numeroPasse == null) {
			this.msg.add("Informe o Número do Passe.");
		}

		if ( codigoItem == null) {
			this.msg.add("Informe o Código do Item.");
		}
		
		if (valor == null) {
			this.msg.add("Informe o Valor do Item. ");
		}

		ItemPasseGeral obj = buscar(PassegeralApplication._EMPRESA,numeroPasse,codigoItem);
		
		if (!this.msg.isEmpty()) {
			throw new DataIntegrityException(String.join(",", this.msg)); 
		}
		
		obj.setValorUnitario(valor);
		
		repo.lancaValorItemPasseGeral(
				obj.getIdfil(),
				obj.getNumeroPasse(),
				obj.getCdItem(),
				valor
				); 
		
		return obj ;
		
	}
	
	public ItemPasseGeral fromDTO(ItemPasseGeralDTO objDTO) {
		return new ItemPasseGeral(
				objDTO.getIdfil(),
				objDTO.getNumeroPasse(),
				objDTO.getCodigoItem(),
				objDTO.getDsItem(),
				objDTO.getDataInclusao(),
				objDTO.getHoraInclusao(),
				objDTO.getQuantidade(),
				objDTO.getUnidMed(),
				objDTO.getQtdeRetorno(),
				objDTO.getSaldo(),
				objDTO.getPesoLiquido(),
				objDTO.getPesoBruto(),
				objDTO.getNumeroVolumes(),
				objDTO.getObs1(),
				objDTO.getObs2(),
				objDTO.getObs3(),
				objDTO.getValorUnitario(),
				objDTO.getValorOrcado(),
				objDTO.getRetornoItensPasseDTO()
				);
	}
	
}
