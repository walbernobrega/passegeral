package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Date;

public class RetornoItemPasseGeralId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String idfil;
	private String numeroPasse;
	private String codigoItem;
	private Date dataRetorno;
	private String horaRetorno;
	
	public RetornoItemPasseGeralId() {
		
	}
	public RetornoItemPasseGeralId(String idfil, String numeroPasse , String codigoItem, Date dataRetorno, String horaRetorno) {
		this.idfil = idfil;
		this.numeroPasse = numeroPasse;
		this.codigoItem = codigoItem;
		this.dataRetorno = dataRetorno;
		this.horaRetorno = horaRetorno;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoItem == null) ? 0 : codigoItem.hashCode());
		result = prime * result + ((dataRetorno == null) ? 0 : dataRetorno.hashCode());
		result = prime * result + ((horaRetorno == null) ? 0 : horaRetorno.hashCode());
		result = prime * result + ((idfil == null) ? 0 : idfil.hashCode());
		result = prime * result + ((numeroPasse == null) ? 0 : numeroPasse.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RetornoItemPasseGeralId other = (RetornoItemPasseGeralId) obj;
		if (codigoItem == null) {
			if (other.codigoItem != null)
				return false;
		} else if (!codigoItem.equals(other.codigoItem))
			return false;
		if (dataRetorno == null) {
			if (other.dataRetorno != null)
				return false;
		} else if (!dataRetorno.equals(other.dataRetorno))
			return false;
		if (horaRetorno == null) {
			if (other.horaRetorno != null)
				return false;
		} else if (!horaRetorno.equals(other.horaRetorno))
			return false;
		if (idfil == null) {
			if (other.idfil != null)
				return false;
		} else if (!idfil.equals(other.idfil))
			return false;
		if (numeroPasse == null) {
			if (other.numeroPasse != null)
				return false;
		} else if (!numeroPasse.equals(other.numeroPasse))
			return false;
		return true;
	}

	
}
