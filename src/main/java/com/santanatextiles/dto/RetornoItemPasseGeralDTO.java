package com.santanatextiles.dto;

import java.io.Serializable;
import java.util.Date;

public class RetornoItemPasseGeralDTO implements Serializable{
		
		private static final long serialVersionUID = 1L;

		private String idfil;
		
		private String numeroPasse;
		
		private String codigoItem;
		
		private Date dataRetorno;

		private String horaRetorno;

		private String codigoPorteiro;

		private Float qtdeRetornada;

		private String notaFiscal;

		private String notaServico;

		private String status;

		private Float pagamentoRetorno;

		private String observacao;
		
		public RetornoItemPasseGeralDTO() {
			
		}

		public RetornoItemPasseGeralDTO(String idfil, String numeroPasse, String codigoItem, Date dataRetorno, String horaRetorno,
				String codigoPorteiro, Float qtdeRetornada, String notaFiscal, String notaServico,
				String status, Float pagamentoRetorno, String observacao) {
			super();
			this.idfil = idfil;
			this.numeroPasse = numeroPasse;
			this.codigoItem = codigoItem;
			this.dataRetorno = dataRetorno;
			this.horaRetorno = horaRetorno;
			this.codigoPorteiro = codigoPorteiro;
			this.qtdeRetornada = qtdeRetornada;
			this.notaFiscal = notaFiscal;
			this.notaServico = notaServico;
			this.status = status;
			this.pagamentoRetorno = pagamentoRetorno;
			this.observacao = observacao;
		}

		
		public String getIdfil() {
			return idfil;
		}

		public void setIdfil(String idfil) {
			this.idfil = idfil;
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


	}
