package com.santanatextiles.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.ItemPasseGeral;
import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.domain.RetornoItemPasseGeral;

@RestController
@RequestMapping(value="/passegeral")
public class PasseGeralResource {

	@RequestMapping(method=RequestMethod.GET)
	public ArrayList<PasseGeral> listar() throws ParseException {
		
		Float um = Float.parseFloat("1");
		Float zero = Float.parseFloat("0");
		
		RetornoItemPasseGeral rit1 = new RetornoItemPasseGeral(
				"047654", 
				"999999", 
				"FLASHPROM R-60",
				new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2023"), 
				"08:48",
				null, 
				null, 
				zero, 
				null, 
				null,
				null, 
				zero, 
				"NOTA FISCAL POR EMAIL", 
				null);
		
		RetornoItemPasseGeral rit2 = new RetornoItemPasseGeral(
				"047788", 
				"999999", 
				"PRENSA EM ALUMINIO C/ REGUA DE MAD 200",
				new SimpleDateFormat("dd/MM/yyyy").parse("07/02/2023"), 
				"13:59",
				null, 
				null, 
				zero, 
				null, 
				null,
				null, 
				zero, 
				null, 
				null);
		
		ArrayList<RetornoItemPasseGeral> retLista1 = new ArrayList<>();
		retLista1.add(rit1);
		
		ArrayList<RetornoItemPasseGeral> retLista2 = new ArrayList<>();
		retLista2.add(rit2);
		
		ItemPasseGeral it1 = new ItemPasseGeral(
				"047654", 
				"999999",
				"FLASHPROM R-60", 
				"NOVA FIACAO INDUSTRIA TEXTIL S/A", 
				new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2023"), 
				"08:48",
				um, 
				"UN",
				zero,
				um, 
				zero, 
				zero, 
				Integer.parseInt("0"),
				"NOTA FISCAL POR EMAIL",
				null,
				null, 
				zero, 
				zero,
				null,
				"E",
				null,
				null,
				retLista1				
				);

		ItemPasseGeral it2 = new ItemPasseGeral(
				"047788", 
				"999999",
				"PRENSA EM ALUMINIO C/ REGUA DE MAD 200", 
				"THIAGO MOREIRA E SILVA ME", 
				new SimpleDateFormat("dd/MM/yyyy").parse("07/02/2023"), 
				"13:59",
				um, 
				"UN",
				zero,
				um, 
				zero, 
				zero, 
				Integer.parseInt("0"),
				null,
				null,
				null, 
				zero, 
				zero,
				null,
				"S",
				null,
				null,
				retLista2				
				);
		
		ArrayList<ItemPasseGeral> itemLista1 = new ArrayList<>();
		ArrayList<ItemPasseGeral> itemLista2 = new ArrayList<>();
		
		itemLista1.add(it1);
		itemLista2.add(it2);
		
		PasseGeral pg1 = new PasseGeral(
				"01",
				"N", 
				"047654", 
				"FOI ENTREGUE AO SR. RÉGIS LIMA ", 
				null, 
				null,
				"E", 
				"00223", 
				"APOIO ADM./MANUTENCAO ELETRICA-FIACAO", 
				"32035", 
				"MACIANO VENTURA DE OLIVEIRA", 
				"14173",
				"NOVA FIACAO INDUSTRIA TEXTIL S/A", 
				"J",
				"001",
				"COMPRAS DIVERSAS", 
				"27058",
				null,
				"N", 
				null,
				"0000",
				"SEM TRANSPORTADORA",
				null, 
				null,
				"27058",
				"KASSIO BRUNO", 
				null,
				null, 
				new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2023"),
				new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2023"), 
				new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2023"),
				new SimpleDateFormat("dd/MM/yyyy").parse("15/01/2023"),
				null,
				"08:30",
				null, 
				"GENILSON (UBER)",
				itemLista1);
		
		PasseGeral pg2 = new PasseGeral(
				"01",
				"N", 
				"047788", 
				null, 
				null, 
				null,
				"S", 
				"00171", 
				"TEARES III -TOYOTA II(ANTIGO VAMATEX)", 
				"50548", 
				"RAFAELA DO AMARAL DE MEDEIROS", 
				"28010",
				"THIAGO MOREIRA E SILVA ME", 
				"J",
				"040",
				"AMOSTRA PECAS DE MAQUINA", 
				"27058",
				null,
				"N", 
				null,
				"0000",
				"SEM TRANSPORTADORA",
				"30087", 
				"EDVANIA RIBEIRO MENDES",
				"27058",
				"KASSIO BRUNO", 
				"CI",
				"449642", 
				new SimpleDateFormat("dd/MM/yyyy").parse("17/02/2023"),
				new SimpleDateFormat("dd/MM/yyyy").parse("07/02/2023"), 
				new SimpleDateFormat("dd/MM/yyyy").parse("28/02/2023"),
				new SimpleDateFormat("dd/MM/yyyy").parse("28/02/2023"),
				null,
				"08:30",
				null, 
				"USIMETAL",
				itemLista2);
		
		ArrayList<PasseGeral> lista = new ArrayList<>();
		
		lista.add(pg1);
		lista.add(pg2);
		
		return lista;
		
		
	}
}
