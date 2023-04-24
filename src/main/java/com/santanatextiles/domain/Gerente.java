package com.santanatextiles.domain;

import java.io.Serializable;

import com.santanatextiles.domain.enums.PerfilUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="SPCC3_DBF",schema="SPC")
@IdClass(GerenteId.class)
public class Gerente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDFIL")
	private String idfil;
	
	@Id
	@Column(name="C3MATR")
	private String matricula;
	
	@Column(name="C3APELI")
	private String login;
	
	@Column(name="C3NOME")
	private String nome;

	@Column(name="C3SENHA")
	private String senha;

	@Column(name="C3PAS")
	private String prorrogador;
	
	@Column(name="C3PERFIL")
	private int perfil;

	public Gerente() {
		
	}

	public Gerente(String idfil, String matricula, String nome, String login, String senha, String prorrogador) {
		super();
		this.idfil = idfil;
		this.matricula = matricula;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.prorrogador = prorrogador;
	}

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
		this.senha= senha;
	}
	
	public String getProrrogador() {
		return prorrogador;
	}

	public void setProrrogador(String prorrogador) {
		this.prorrogador = prorrogador;
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
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		if (idfil == null) {
			if (other.idfil != null)
				return false;
		} else if (!idfil.equals(other.idfil))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
