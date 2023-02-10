package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class TransacaoId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String codigo;
	
	public TransacaoId() {
		
	}
	public TransacaoId(String idfil, String codigo) {
		this.idfil = idfil;
		this.codigo = codigo;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoId transacaoId = (TransacaoId) o;
        return idfil.equals(transacaoId.idfil) &&
                codigo.equals(transacaoId.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, codigo);
    }
}
