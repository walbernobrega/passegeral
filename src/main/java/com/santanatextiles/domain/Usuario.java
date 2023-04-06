package com.santanatextiles.domain;

import java.io.Serializable;

import com.santanatextiles.domain.enums.TipoUsuario;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	private String idfil;
	
	private String codigo;

	private String login;

	private String nome;

	private String senha;

	private boolean prorrogador;
	
	private String tipoUsuario;
	
	public Usuario() {
		
	}

	public Usuario(String idfil, String codigo , String login, String nome, String senha, boolean prorrogador, String tipoUsuario) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.prorrogador = prorrogador;
		this.tipoUsuario = tipoUsuario;
		
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

	

}
