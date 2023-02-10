package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class ItemPasseGeralId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String numeroPasse;
	private String codigoItem;
	
	public ItemPasseGeralId() {
		
	}
	public ItemPasseGeralId(String idfil, String numeroPasse, String codigoItem) {
		this.idfil = idfil;
		this.numeroPasse = numeroPasse;
		this.codigoItem = codigoItem;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPasseGeralId itemPasseGeralId = (ItemPasseGeralId) o;
        return idfil.equals(itemPasseGeralId.idfil) &&
                numeroPasse.equals(itemPasseGeralId.numeroPasse) &&
                codigoItem.equals(itemPasseGeralId.codigoItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, numeroPasse, codigoItem);
    }
}
