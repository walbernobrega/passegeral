package com.santanatextiles.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SPCD4_DBF",schema="SPC")
public class UsuarioPasse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="D4MATR")
	private String matricula;
	
	@Column(name="D4APELI")
	private String login;
	
	@Column(name="D4NOME")
	private String nome;

	@Column(name="D4SENHA")
	private String senha;
	
	@Column(name="IDFIL")
	private String empresa;
	
	public UsuarioPasse() {
		
	}

	public UsuarioPasse(String login, String matricula, String nome, String senha,String empresa) {
		super();
		this.login = login;
		this.matricula = matricula;
		this.nome = nome;
		this.senha = senha;
		this.empresa = empresa;
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
		this.senha = senha;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
