package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="BALJ2_DBF",schema="BAL")
@IdClass(RetornoItemPasseGeralId.class)
public class RetornoItemPasseGeral implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IDFIL")
	private String idfil;
	
	@Id
	@Column(name="J2COD")
	private String numeroPasse;
	
	@Id
	@Column(name="J2ITEM")
	@NotEmpty(message="Informe o Código do Item")
	private String codigoItem;

	@Id
	@Column(name="J2DATA")
	@JsonFormat(pattern="dd/MM/yyyy")
	@NotNull(message="Informe a Data do Retorno")
	private Date dataRetorno;

	@Id
	@Column(name="J2HORA")
	private String horaRetorno;
	
	@Column(name="J2QTDE")
	private Float qtdeRetornada;
	
	@Transient
	private String descricaoItem;
	
	@Column(name="J2MATR")
	@NotEmpty(message="Informe a Matricula do Porteiro")
	private String codigoPorteiro;

	@Column(name="J2NOTA")
	private String notaFiscal;

	@Column(name="J2STAT")
	private String status;

	@Column(name="J2VURE")
	private Float valorRetorno;

	@Column(name="J2PGRT")
	private String pagamentoRetorno;

	@Column(name="J2OBSV")
	@Size(max=40,message = "Observação Deve Possuir no Máximo 40 Caracteres")
	private String observacao;

	@Column(name="J2NSERV")
	private String notaServico;
	
	@Transient
	private String dsPorteiro;
	
	@Transient
	private String tipoOperacao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="D0003_ID_LOCALIZACAO", insertable = false, updatable = false),
	    @JoinColumn(name="j2item", referencedColumnName="D0422_ID_ITEM", insertable = false, updatable = false)
	})
	private Item item;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j2cod", referencedColumnName="j1cod", insertable = false, updatable = false),
	    @JoinColumn(name="j2item", referencedColumnName="j1item", insertable = false, updatable = false)
	})
	private ItemPasseGeral itemPasseGeral;
	
	public RetornoItemPasseGeral() {
		
	}

	public RetornoItemPasseGeral(String idfil, String numeroPasse, String codigoItem, String descricaoItem, Date dataRetorno, String horaRetorno,
			String codigoPorteiro, String dsPorteiro, Float qtdeRetornada, String notaFiscal, String notaServico,
			String status, Float valorRetorno , String pagamentoRetorno, String observacao, String tipoOperacao, ItemPasseGeral itemPasseGeral) {
		super();
		this.idfil = idfil;
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
		this.valorRetorno = valorRetorno;
		this.pagamentoRetorno = pagamentoRetorno;
		this.observacao = observacao;
		this.tipoOperacao = tipoOperacao;
		this.itemPasseGeral = itemPasseGeral;
	}

	public RetornoItemPasseGeral(String idfil, String numeroPasse, String codigoItem, Date dataRetorno, String horaRetorno,
			String codigoPorteiro, Float qtdeRetornada, String notaFiscal, String notaServico, String status, Float valorRetorno, 
			String pagamentoRetorno, String observacao) {
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
		this.valorRetorno = valorRetorno;
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

	public String getDescricaoItem() {
		return descricaoItem;
	}

	public void setDescricaoItem(String descricaoItem) {
		this.descricaoItem = descricaoItem;
	}

	
	public Float getValorRetorno() {
		return valorRetorno;
	}

	public void setValorRetorno(Float valorRetorno) {
		this.valorRetorno = valorRetorno;
	}

	public String getPagamentoRetorno() {
		return pagamentoRetorno;
	}
	
	public void setPagamentoRetorno(String pagamentoRetorno) {
		this.pagamentoRetorno = pagamentoRetorno;
	}

	public ItemPasseGeral getItemPasseGeral() {
		return itemPasseGeral;
	}

	public void setItemPasseGeral(ItemPasseGeral itemPasseGeral) {
		this.itemPasseGeral = itemPasseGeral;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoItem == null) ? 0 : codigoItem.hashCode());
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
		RetornoItemPasseGeral other = (RetornoItemPasseGeral) obj;
		if (codigoItem == null) {
			if (other.codigoItem != null)
				return false;
		} else if (!codigoItem.equals(other.codigoItem))
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
