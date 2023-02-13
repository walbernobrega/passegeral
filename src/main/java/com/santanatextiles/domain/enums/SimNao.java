package com.santanatextiles.domain.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum SimNao {
	
	SIM("S", "Sim"),
	NAO("N", "Não");
	
	private String codigo;
	private String descricao;
	
	private SimNao(String codigo, String descricao) {
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
	
	public static SimNao toEnum(String codigo) {
		if(codigo == null) {
			return null;
		}
		
		for (SimNao x : SimNao.values()) {
			if( codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}
	
	@Converter(autoApply = true)
    public static class SimNaoAttributeConverter implements AttributeConverter<SimNao, String> {

        @Override
        public String convertToDatabaseColumn(SimNao codigo) {
            return codigo.getCodigo();
        }

        @Override
        public SimNao convertToEntityAttribute(String valor) {
            if(valor.equals("S")) {
                return SIM;
            } else if (valor.equals("N")){
                return NAO;
            } else {
                return null;
            }

        }
    }

}
