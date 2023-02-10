package com.santanatextiles.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.domain.UsuarioPasse;

@RestController
@RequestMapping(value="/usuariopasse")
public class UsuarioPasseResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<UsuarioPasse> listar() {
		
		UsuarioPasse usuario1 = new UsuarioPasse("dalton","17071","dalton","1234","01");
		UsuarioPasse usuario2 = new UsuarioPasse("EMENDES","30087","EDVANIA RIBEIRO MENDES","1234","01");
		UsuarioPasse usuario3 = new UsuarioPasse("KBRUNO","27058","KASSIO BRUNO","1234","01");
		
		List<UsuarioPasse> lista =new ArrayList<>();
		lista.add(usuario1);
		lista.add(usuario2);
		lista.add(usuario3);
				
		return lista;
	}
}
