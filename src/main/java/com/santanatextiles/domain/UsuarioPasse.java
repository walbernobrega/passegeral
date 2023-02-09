package com.santanatextiles.domain;

import java.io.Serializable;

public class UsuarioPasse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String login;
	
	private String matricula;

	private String nome;

	private String senhaUsuario;

	private String senhaGerente;

	private String senhaPorteiro;
	
	private String empresa;
	
	private boolean prorrogador;
	
	public UsuarioPasse() {
		
	}

	public UsuarioPasse(String login, String matricula, String nome, String senhaUsuario, String senhaGerente, String senhaPorteiro,
			String empresa, boolean prorrogador) {
		super();
		this.login = login;
		this.matricula = matricula;
		this.nome = nome;
		this.senhaUsuario = senhaUsuario;
		this.senhaGerente = senhaGerente;
		this.senhaPorteiro = senhaPorteiro;
		this.empresa = empresa;
		this.prorrogador = prorrogador;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getSenhaGerente() {
		return senhaGerente;
	}

	public void setSenhaGerente(String senhaGerente) {
		this.senhaGerente = senhaGerente;
	}

	public String getSenhaPorteiro() {
		return senhaPorteiro;
	}

	public void setSenhaPorteiro(String senhaPorteiro) {
		this.senhaPorteiro = senhaPorteiro;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public boolean isProrrogador() {
		return prorrogador;
	}

	public void setProrrogador(boolean prorrogador) {
		this.prorrogador = prorrogador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
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
		UsuarioPasse other = (UsuarioPasse) obj;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}

	
}
