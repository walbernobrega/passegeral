package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class PorteiroId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String codigo;
	
	public PorteiroId() {
		
	}
	public PorteiroId(String idfil, String codigo) {
		this.idfil = idfil;
		this.codigo = codigo;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PorteiroId porteiroId = (PorteiroId) o;
        return idfil.equals(porteiroId.idfil) &&
                codigo.equals(porteiroId.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, codigo);
    }
}
