package com.santanatextiles.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="SCED4_DBF", schema="SCE")
@IdClass(CentroDeCustoId.class)
public class CentroDeCusto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDFIL")
	private String idfil;
	
	@Id
	@Column(name="D4COD")
	private String codigo;
	
	@Column(name="D4DESC")
	private String descricao;
	
	public CentroDeCusto() {
		
	}

	public CentroDeCusto(String codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
		CentroDeCusto other = (CentroDeCusto) obj;
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
