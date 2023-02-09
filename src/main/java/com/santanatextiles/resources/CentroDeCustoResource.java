package com.santanatextiles.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.CentroDeCusto;

@RestController
@RequestMapping(value="/centrodecusto")
public class CentroDeCustoResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<CentroDeCusto> listar() {
		
		CentroDeCusto cc1 = new CentroDeCusto("00115","INFORMATICA");
		CentroDeCusto cc2 = new CentroDeCusto("00112","PESSOAL");
		CentroDeCusto cc3 = new CentroDeCusto("00171","TEARES III -TOYOTA II(ANTIGO VAMATEX)");
		CentroDeCusto cc4 = new CentroDeCusto("00223","APOIO ADM./MANUTENCAO ELETRICA-FIACAO");
		
		List<CentroDeCusto> lista = new ArrayList<>();
		
		lista.add(cc1);
		lista.add(cc2);
		lista.add(cc3);
		lista.add(cc4);
		
		return lista;
		
	}

}
