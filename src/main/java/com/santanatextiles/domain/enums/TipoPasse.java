package com.santanatextiles.domain.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum TipoPasse {
	
	ENTRADA("E", "Entrada"),
	SAIDA("S", "Saída");
	
	private String codigo;
	private String descricao;
	
	private TipoPasse(String codigo, String descricao) {
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
	
	public static TipoPasse toEnum(String codigo) {
		if(codigo == null) {
			return null;
		}
		
		for (TipoPasse x : TipoPasse.values()) {
			if( codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}

	@Converter(autoApply = true)
    public static class TipoPasseAttributeConverter implements AttributeConverter<TipoPasse, String> {

        @Override
        public String convertToDatabaseColumn(TipoPasse codigo) {
            return codigo.getCodigo();
        }

        @Override
        public TipoPasse convertToEntityAttribute(String valor) {
            if(valor.equals("S")) {
                return SAIDA;
            } else if (valor.equals("E")){
                return ENTRADA;
            } else {
                return null;
            }

        }
    }
}
