package com.santanatextiles.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SPCC3_DBF",schema="SPC")
public class Gerente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="C3MATR")
	private String matricula;
	
	@Column(name="C3APELI")
	private String login;
	
	@Column(name="C3NOME")
	private String nome;

	@Column(name="C3SENHA")
	private String senha;

	@Column(name="IDFIL")
	private String empresa;
	
	private boolean prorrogador;
	
	public Gerente() {
		
	}

	public Gerente(String login, String matricula, String nome, String senha, String empresa, boolean prorrogador) {
		super();
		this.login = login;
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha= senha;
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
		Gerente other = (Gerente) obj;
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
