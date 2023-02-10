package com.santanatextiles.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.ItemPasseGeral;
import com.santanatextiles.domain.RetornoItemPasseGeral;

@RestController
@RequestMapping(value="/itempassegeral")
public class ItemPasseGeralResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ArrayList<ItemPasseGeral> listar() throws NumberFormatException, ParseException {

		
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
		
		ArrayList<ItemPasseGeral> lista = new ArrayList<>();
		
		lista.add(it1);
		lista.add(it2);
		
		return lista;
	}

}
