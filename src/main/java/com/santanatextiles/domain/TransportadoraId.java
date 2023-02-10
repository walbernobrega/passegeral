package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class TransportadoraId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String codigo;
	
	public TransportadoraId() {
		
	}
	public TransportadoraId(String idfil, String codigo) {
		this.idfil = idfil;
		this.codigo = codigo;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransportadoraId transportadoraId = (TransportadoraId) o;
        return idfil.equals(transportadoraId.idfil) &&
                codigo.equals(transportadoraId.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, codigo);
    }
}
