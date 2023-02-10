package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class CentroDeCustoId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String codigo;
	
	public CentroDeCustoId() {
		
	}
	public CentroDeCustoId(String idfil, String codigo) {
		this.idfil = idfil;
		this.codigo = codigo;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CentroDeCustoId centroDeCustoId = (CentroDeCustoId) o;
        return idfil.equals(centroDeCustoId.idfil) &&
                codigo.equals(centroDeCustoId.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, codigo);
    }
}
