package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioPasseId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String matricula;
	
	public UsuarioPasseId() {
		
	}
	public UsuarioPasseId(String idfil, String matricula) {
		this.idfil = idfil;
		this.matricula = matricula;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPasseId usuarioPasseId = (UsuarioPasseId) o;
        return idfil.equals(usuarioPasseId.idfil) &&
                matricula.equals(usuarioPasseId.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, matricula);
    }
}
