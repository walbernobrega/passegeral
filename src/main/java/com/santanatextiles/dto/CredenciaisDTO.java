package com.santanatextiles.dto;

import java.io.Serializable;

public class CredenciaisDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String codigo;
	private String senha;
	
	public CredenciaisDTO() {
		
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
