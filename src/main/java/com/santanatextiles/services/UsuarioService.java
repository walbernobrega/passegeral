package com.santanatextiles.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Gerente;
import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.domain.Usuario;
import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.domain.enums.TipoUsuario;
import com.santanatextiles.resources.utils.URL;
import com.santanatextiles.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private GerenteService gerenteService;
	
	@Autowired
	private PorteiroService porteiroService;
	
	@Autowired
	private UsuarioPasseService usuarioPasseService;
	
	private ArrayList<String> msg = new ArrayList<>();
	
	public Usuario verificaLogin(String codigo, String senha, String idfil) {
		
		this.msg.clear();
		
		UsuarioPasse objUsuario = usuarioPasseService.buscar(idfil , codigo);
		
		if(objUsuario != null) {
			
			PassegeralApplication._USUARIO.setIdfil(objUsuario.getIdfil());
			PassegeralApplication._USUARIO.setCodigo(objUsuario.getMatricula());
			PassegeralApplication._USUARIO.setLogin(objUsuario.getLogin());
			PassegeralApplication._USUARIO.setNome(objUsuario.getNome());
			PassegeralApplication._USUARIO.setSenha(objUsuario.getSenha());
			PassegeralApplication._USUARIO.setTipoUsuario(TipoUsuario.USUARIO);
		}
		
		Porteiro objPorteiro = porteiroService.buscar(idfil , codigo);
		
		if(objPorteiro != null) {
			PassegeralApplication._USUARIO.setIdfil(objPorteiro.getIdfil());
			PassegeralApplication._USUARIO.setCodigo(objPorteiro.getCodigo());
			PassegeralApplication._USUARIO.setLogin(objPorteiro.getNome());
			PassegeralApplication._USUARIO.setNome(objPorteiro.getNome());
			PassegeralApplication._USUARIO.setSenha(objPorteiro.getSenha());
			PassegeralApplication._USUARIO.setTipoUsuario(TipoUsuario.PORTEIRO);
		}
		
		Gerente objGerente = gerenteService.buscar(idfil , codigo);
		
		if(objGerente != null) {
			PassegeralApplication._USUARIO.setIdfil(objGerente.getIdfil());
			PassegeralApplication._USUARIO.setCodigo(objGerente.getMatricula());
			PassegeralApplication._USUARIO.setLogin(objGerente.getLogin());
			PassegeralApplication._USUARIO.setNome(objGerente.getNome());
			PassegeralApplication._USUARIO.setSenha(objGerente.getSenha());
			PassegeralApplication._USUARIO.setTipoUsuario(TipoUsuario.GERENTE);
			if ("S".equals(objGerente.getProrrogador())) {
				PassegeralApplication._USUARIO.setProrrogador(true);
			} else {
				PassegeralApplication._USUARIO.setProrrogador(false);
			}
		}
		
		if (PassegeralApplication._USUARIO.getLogin() == null) {
			this.msg.add("Usuário Não Cadastrado.");
		}
		
		if (!URL.verificaSenha(PassegeralApplication._USUARIO.getSenha(), senha)) {
			this.msg.add("Senha Inválida.");
		}
		
		if (!this.msg.isEmpty()) {
			throw new ObjectNotFoundException(String.join(",", this.msg)); 
		}
		
		return PassegeralApplication._USUARIO;
		
	}

}
