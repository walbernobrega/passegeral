package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Date;

public class RetornoItemPasseGeral implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String numeroPasse;
	
	private String codigoItem;
	
	private String descricaoItem;
	
	private Date dataRetorno;

	private String horaRetorno;

	private String codigoPorteiro;

	private String dsPorteiro;

	private Float qtdeRetornada;

	private String notaFiscal;

	private String notaServico;

	private String status;

	private Float pagamentoRetorno;

	private String observacao;
	
	private String tipoOperacao;

	public RetornoItemPasseGeral() {
		
	}

	public RetornoItemPasseGeral(String numeroPasse, String codigoItem, String descricaoItem, Date dataRetorno, String horaRetorno,
			String codigoPorteiro, String dsPorteiro, Float qtdeRetornada, String notaFiscal, String notaServico,
			String status, Float pagamentoRetorno, String observacao, String tipoOperacao) {
		super();
		this.numeroPasse = numeroPasse;
		this.codigoItem = codigoItem;
		this.descricaoItem = descricaoItem;
		this.dataRetorno = dataRetorno;
		this.horaRetorno = horaRetorno;
		this.codigoPorteiro = codigoPorteiro;
		this.dsPorteiro = dsPorteiro;
		this.qtdeRetornada = qtdeRetornada;
		this.notaFiscal = notaFiscal;
		this.notaServico = notaServico;
		this.status = status;
		this.pagamentoRetorno = pagamentoRetorno;
		this.observacao = observacao;
		this.tipoOperacao = tipoOperacao;
	}

	public String getNumeroPasse() {
		return numeroPasse;
	}

	public void setNumeroPasse(String numeroPasse) {
		this.numeroPasse = numeroPasse;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public Date getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

	public String getHoraRetorno() {
		return horaRetorno;
	}

	public void setHoraRetorno(String horaRetorno) {
		this.horaRetorno = horaRetorno;
	}

	public String getCodigoPorteiro() {
		return codigoPorteiro;
	}

	public void setCodigoPorteiro(String codigoPorteiro) {
		this.codigoPorteiro = codigoPorteiro;
	}

	public String getDsPorteiro() {
		return dsPorteiro;
	}

	public void setDsPorteiro(String dsPorteiro) {
		this.dsPorteiro = dsPorteiro;
	}

	public Float getQtdeRetornada() {
		return qtdeRetornada;
	}

	public void setQtdeRetornada(Float qtdeRetornada) {
		this.qtdeRetornada = qtdeRetornada;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getNotaServico() {
		return notaServico;
	}

	public void setNotaServico(String notaServico) {
		this.notaServico = notaServico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getPagamentoRetorno() {
		return pagamentoRetorno;
	}

	public void setPagamentoRetorno(Float pagamentoRetorno) {
		this.pagamentoRetorno = pagamentoRetorno;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoItem == null) ? 0 : codigoItem.hashCode());
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
		RetornoItemPasseGeral other = (RetornoItemPasseGeral) obj;
		if (codigoItem == null) {
			if (other.codigoItem != null)
				return false;
		} else if (!codigoItem.equals(other.codigoItem))
			return false;
		if (numeroPasse == null) {
			if (other.numeroPasse != null)
				return false;
		} else if (!numeroPasse.equals(other.numeroPasse))
			return false;
		return true;
	}

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}
	
	

}
