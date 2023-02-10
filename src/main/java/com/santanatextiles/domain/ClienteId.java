package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class ClienteId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String codigo;
	
	public ClienteId() {
		
	}
	public ClienteId(String idfil, String codigo) {
		this.idfil = idfil;
		this.codigo = codigo;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteId clienteId = (ClienteId) o;
        return idfil.equals(clienteId.idfil) &&
                codigo.equals(clienteId.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfil, codigo);
    }
}
