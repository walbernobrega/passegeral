package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class FornecedorClienteId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String entidade;
	private String codigo;
	
	public FornecedorClienteId() {
		
	}
	public FornecedorClienteId(String idfil, String entidade , String codigo) {
		this.idfil = idfil;
		this.entidade = entidade;
		this.codigo = codigo;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FornecedorClienteId fornecedorClienteId = (FornecedorClienteId) o;
        return idfil.equals(fornecedorClienteId.idfil) &&
        		entidade.equals(fornecedorClienteId.entidade) &&
                codigo.equals(fornecedorClienteId.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, entidade , codigo);
    }
}
