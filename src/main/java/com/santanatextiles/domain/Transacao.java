package com.santanatextiles.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name="BALF6_DBF",schema="BAL")
@IdClass(TransacaoId.class)
public class Transacao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDFIL")
	private String idfil;
	
	@Id
	@Column(name="F6COD")
	private String codigo;
	
	@Column(name="F6DESC")
	private String descricao;
	
	@Column(name="F6GEREN")
	private String gerente;
	
	@Column(name="F6CLIFO")
	private String clifo;

	public Transacao() {
		
	}

	public Transacao(String idfil, String codigo, String descricao, String gerente, String clifo ) {
		super();
		this.idfil = idfil;
		this.codigo = codigo;
		this.descricao = descricao;
		this.gerente = gerente;
		this.clifo = clifo;
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

	public String getClifo() {
		return clifo;
	}

	public void setClifo(String clifo) {
		this.clifo = clifo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGerente() {
		return gerente;
	}

	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	
	public boolean isAprovador(String aprovador) {
		boolean retorno = false;
		for(int i=0;i<10;i++){
			if(this.gerente.substring((i*5),(i*5)+5).equals(aprovador)){
				retorno = true;
				break;
			}
		}
		return retorno;
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
		Transacao other = (Transacao) obj;
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
