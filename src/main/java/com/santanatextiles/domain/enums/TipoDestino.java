package com.santanatextiles.domain.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum TipoDestino {
	
	CLIENTE("C", "Cliente"),
	FORNECEDOR("F", "Fornecedor");
	
	private String codigo;
	private String descricao;
	
	private TipoDestino(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoDestino toEnum(String codigo) {
		if(codigo == null) {
			return null;
		}
		
		for (TipoDestino x : TipoDestino.values()) {
			if( codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}
	
	@Converter(autoApply = true)
    public static class TipoDestinoAttributeConverter implements AttributeConverter<TipoDestino, String> {

        @Override
        public String convertToDatabaseColumn(TipoDestino codigo) {
            return codigo.getCodigo();
        }

        @Override
        public TipoDestino convertToEntityAttribute(String valor) {
            if(valor.equals("C")) {
                return CLIENTE;
            } else if (valor.equals("F")){
                return FORNECEDOR;
            } else {
                return null;
            }

        }
    }

}
