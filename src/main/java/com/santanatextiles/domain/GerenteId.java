package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class GerenteId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String matricula;
	
	public GerenteId() {
		
	}
	public GerenteId(String idfil, String matricula) {
		this.idfil = idfil;
		this.matricula = matricula;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GerenteId gerenteId = (GerenteId) o;
        return idfil.equals(gerenteId.idfil) &&
                matricula.equals(gerenteId.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, matricula);
    }
}
