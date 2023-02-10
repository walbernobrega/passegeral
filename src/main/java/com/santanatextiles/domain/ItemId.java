package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Objects;

public class ItemId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long localizacao;
	private Long codigo;
	
	public ItemId() {
		
	}
	public ItemId(Long localizacao, Long codigo) {
		this.localizacao = localizacao;
		this.codigo = codigo;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemId itemId = (ItemId) o;
        return localizacao.equals(itemId.localizacao) &&
                codigo.equals(itemId.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localizacao, codigo);
    }
}
