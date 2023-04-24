package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.santanatextiles.domain.enums.PerfilUsuario;
import com.santanatextiles.domain.enums.TipoUsuario;

public class Usuario implements UserDetails,Serializable{

	private static final long serialVersionUID = 1L;

	private String idfil;
	
	private String codigo;

	private String login;

	private String nome;

	private String senha;

	private boolean prorrogador;
	
	private String tipoUsuario;
	
	private int perfil;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	public Usuario() {
		
	}

	public Usuario(String idfil, String codigo , String login, String nome, String senha, boolean prorrogador, String tipoUsuario, int perfil,
			Set<PerfilUsuario> perfis) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.prorrogador = prorrogador;
		this.tipoUsuario = tipoUsuario;
		this.perfil = perfil;
		this.authorities = perfis.stream().map( x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
		
	}
	
	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isProrrogador() {
		return prorrogador;
	}

	public void setProrrogador(boolean prorrogador) {
		this.prorrogador = prorrogador;
	}

	public TipoUsuario getTipoUsuario() {
		return TipoUsuario.toEnum(tipoUsuario);
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario.getCodigo();
	}
	
	public PerfilUsuario getPerfil() {
		return PerfilUsuario.toEnum(perfil);
	}

	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil.getCodigo();
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idfil == null) ? 0 : idfil.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (idfil == null) {
			if (other.idfil != null)
				return false;
		} else if (!idfil.equals(other.idfil))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return codigo;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}
