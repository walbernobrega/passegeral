package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class RetornoItemPasseGeralId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String numeroPasse;
	private String codigoItem;
	
	public RetornoItemPasseGeralId() {
		
	}
	public RetornoItemPasseGeralId(String idfil, String numeroPasse , String codigoItem) {
		this.idfil = idfil;
		this.numeroPasse = numeroPasse;
		this.codigoItem = codigoItem;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RetornoItemPasseGeralId retornoItemPasseGeralId = (RetornoItemPasseGeralId) o;
        return idfil.equals(retornoItemPasseGeralId.idfil) &&
                numeroPasse.equals(retornoItemPasseGeralId.numeroPasse) &&
                codigoItem.equals(retornoItemPasseGeralId.codigoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, numeroPasse, codigoItem);
    }
}
