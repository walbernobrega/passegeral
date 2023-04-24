package com.santanatextiles.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.Gerente;
import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.domain.Usuario;
import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.domain.enums.PerfilUsuario;
import com.santanatextiles.domain.enums.TipoUsuario;
import com.santanatextiles.resources.utils.URL;
import com.santanatextiles.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private GerenteService gerenteService;
	
	@Autowired
	private PorteiroService porteiroService;
	
	@Autowired
	private UsuarioPasseService usuarioPasseService;
	
	private ArrayList<String> msg = new ArrayList<>();
	
	@Override
	public UserDetails loadUserByUsername(String codigo) throws UsernameNotFoundException {
		this.msg.clear();
		
		String idfil = PassegeralApplication._EMPRESA;
		
		UsuarioPasse objUsuario = usuarioPasseService.buscar(idfil , codigo);
		
		if(objUsuario != null) {
			
			Set<PerfilUsuario> perfil = new HashSet<PerfilUsuario>();
			
			perfil.add(objUsuario.getPerfil());
			
			String senhaBCryptografada = URL.senhaBCryptografada(objUsuario.getSenha());
			
			PassegeralApplication._USUARIO = new Usuario(
					objUsuario.getIdfil(), 
					objUsuario.getMatricula() , 
					objUsuario.getLogin(), 
					objUsuario.getNome(), 
					senhaBCryptografada, 
					false, 
					TipoUsuario.USUARIO.toString(), 
					objUsuario.getPerfil().getCodigo(),
					perfil);
			
		}
		
		Porteiro objPorteiro = porteiroService.buscar(idfil , codigo);
		
		if(objPorteiro != null) {
			
			Set<PerfilUsuario> perfil = new HashSet<PerfilUsuario>();
			
			perfil.add(objPorteiro.getPerfil());
			
			String senhaBCryptografada = URL.senhaBCryptografada(objPorteiro.getSenha());
			
			PassegeralApplication._USUARIO = new Usuario(
					objPorteiro.getIdfil(), 
					objPorteiro.getCodigo() , 
					objPorteiro.getNome(), 
					objPorteiro.getNome(), 
					senhaBCryptografada, 
					false, 
					TipoUsuario.PORTEIRO.toString(), 
					objPorteiro.getPerfil().getCodigo(),
					perfil);
			
		}
		
		Gerente objGerente = gerenteService.buscar(idfil , codigo);
		
		if(objGerente != null) {
			Set<PerfilUsuario> perfil = new HashSet<PerfilUsuario>();
			
			perfil.add(objGerente.getPerfil());
			
			String senhaBCryptografada = URL.senhaBCryptografada(objGerente.getSenha());
			
			PassegeralApplication._USUARIO = new Usuario(
					objGerente.getIdfil(), 
					objGerente.getMatricula() , 
					objGerente.getLogin(), 
					objGerente.getNome(), 
					senhaBCryptografada, 
					("S".equals(objGerente.getProrrogador()) ? true : false), 
					TipoUsuario.GERENTE.toString(), 
					objGerente.getPerfil().getCodigo(),
					perfil);
		}
		
		if (PassegeralApplication._USUARIO.getLogin() == null) {
			this.msg.add("Usuário Não Cadastrado.");
		}
		
		if (!this.msg.isEmpty()) {
			throw new ObjectNotFoundException(String.join(",", this.msg)); 
		}
		
		return PassegeralApplication._USUARIO;
		
	}
	
	
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
			PassegeralApplication._USUARIO.setPerfil(objUsuario.getPerfil());
		}
		
		Porteiro objPorteiro = porteiroService.buscar(idfil , codigo);
		
		if(objPorteiro != null) {
			PassegeralApplication._USUARIO.setIdfil(objPorteiro.getIdfil());
			PassegeralApplication._USUARIO.setCodigo(objPorteiro.getCodigo());
			PassegeralApplication._USUARIO.setLogin(objPorteiro.getNome());
			PassegeralApplication._USUARIO.setNome(objPorteiro.getNome());
			PassegeralApplication._USUARIO.setSenha(objPorteiro.getSenha());
			PassegeralApplication._USUARIO.setTipoUsuario(TipoUsuario.PORTEIRO);
			PassegeralApplication._USUARIO.setPerfil(objPorteiro.getPerfil());
		}
		
		Gerente objGerente = gerenteService.buscar(idfil , codigo);
		
		if(objGerente != null) {
			PassegeralApplication._USUARIO.setIdfil(objGerente.getIdfil());
			PassegeralApplication._USUARIO.setCodigo(objGerente.getMatricula());
			PassegeralApplication._USUARIO.setLogin(objGerente.getLogin());
			PassegeralApplication._USUARIO.setNome(objGerente.getNome());
			PassegeralApplication._USUARIO.setSenha(objGerente.getSenha());
			PassegeralApplication._USUARIO.setTipoUsuario(TipoUsuario.GERENTE);
			PassegeralApplication._USUARIO.setPerfil(objGerente.getPerfil());
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
	
	public static Usuario authenticated() {
		try {
			return (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
