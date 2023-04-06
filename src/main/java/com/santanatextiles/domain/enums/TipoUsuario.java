package com.santanatextiles.domain.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

public enum TipoUsuario {
	
	GERENTE("G", "Gerente"),
	PORTEIRO("P", "Porteiro"),
	USUARIO("U", "Usuário");
	
	private String codigo;
	private String descricao;
	
	private TipoUsuario(String codigo, String descricao) {
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
	
	public static TipoUsuario toEnum(String codigo) {
		if(codigo == null) {
			return null;
		}
		
		for (TipoUsuario x : TipoUsuario.values()) {
			if( codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + codigo);
	}

	@Converter(autoApply = true)
    public static class TipoPasseAttributeConverter implements AttributeConverter<TipoUsuario, String> {

        @Override
        public String convertToDatabaseColumn(TipoUsuario codigo) {
            return codigo.getCodigo();
        }

        @Override
        public TipoUsuario convertToEntityAttribute(String valor) {
            if(valor.equals("G")) {
                return GERENTE;
            } else if (valor.equals("P")){
                return PORTEIRO;
            } else if (valor.equals("U")){
                return USUARIO;
            } else {
                return null;
            }

        }
    }
}
