package com.santanatextiles.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="BALE5_DBF",schema="BAL")
@IdClass(PorteiroId.class)
public class Porteiro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDFIL")
	private String idfil;
	
	@Id
	@Column(name="E5COD")
	private String codigo;
	
	@Column(name="E5NOME")
	private String nome;

	@Column(name="E5SENHA")
	private String senha;

	public Porteiro() {
		
	}

	public Porteiro(String idfil, String codigo, String nome, String senha) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.nome = nome;
		this.senha = senha;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((idfil == null) ? 0 : idfil.hashCode());
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
		Porteiro other = (Porteiro) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (idfil == null) {
			if (other.idfil != null)
				return false;
		} else if (!idfil.equals(other.idfil))
			return false;
		return true;
	}

	
}
