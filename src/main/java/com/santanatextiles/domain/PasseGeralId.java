package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class PasseGeralId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String numeroPasse;
	
	public PasseGeralId() {
		
	}
	public PasseGeralId(String idfil, String numeroPasse) {
		this.idfil = idfil;
		this.numeroPasse = numeroPasse;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasseGeralId passeGeralId = (PasseGeralId) o;
        return idfil.equals(passeGeralId.idfil) &&
                numeroPasse.equals(passeGeralId.numeroPasse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, numeroPasse);
    }
}
