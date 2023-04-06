package com.santanatextiles.domain.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum TipoTransporte {
	
	PROPRIO("P", "Próprio"),
	TERCEIRO("T", "Terceiro"),
	NENHUM("N", "Nenhum"),
	FUNCIONARIO("F", "Funcionário");
	
	private String codigo;
	private String descricao;
	
	private TipoTransporte(String codigo, String descricao) {
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
	
	public static TipoTransporte toEnum(String codigo) {
		if(codigo == null) {
			return null;
		}
		
		for (TipoTransporte x : TipoTransporte.values()) {
			if( codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}
	
	@Converter(autoApply = true)
    public static class TipoDestinoAttributeConverter implements AttributeConverter<TipoTransporte, String> {

        @Override
        public String convertToDatabaseColumn(TipoTransporte codigo) {
            return codigo.getCodigo();
        }

        @Override
        public TipoTransporte convertToEntityAttribute(String valor) {
            if(valor.equals("P")) {
                return PROPRIO;
            } else if (valor.equals("T")){
                return TERCEIRO;
            } else if (valor.equals("N")){
                return NENHUM;
            } else if (valor.equals("F")){
                return FUNCIONARIO;    
            } else {
                return null;
            }

        }
    }

}
