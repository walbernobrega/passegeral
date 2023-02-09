package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class ItemPasseGeral implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String numeroPasse;
    private String cdItem;
	private String dsItem;
	private String dsCliFor;
	private Date dataInclusao;
	private String horaInclusao;
	private Float quantidade;
	private String unidMed;
	private Float qtdeRetorno;
	private Float saldo;
	private Float pesoLiquido;
	private Float pesoBruto;
	private Integer numeroVolumes;
	private String obs1;
	private String obs2;
	private String obs3;
	private Float valorUnitario;
	private Float valorOrcado;
	private String statusPasse;
	private String entradaSaida;
	private String retorno;
	private String operacao;
	private ArrayList<RetornoItemPasseGeral> retornoItemPasse;
	
	public ItemPasseGeral() {
		
	}

	public ItemPasseGeral(String numeroPasse, String cdItem,
			String dsItem, String dsCliFor, Date dataInclusao, String horaInclusao, Float quantidade, String unidMed,
			Float qtdeRetorno, Float saldo, Float pesoLiquido, Float pesoBruto, Integer numeroVolumes, String obs1,
			String obs2, String obs3, Float valorUnitario, Float valorOrcado, String statusPasse, String entradaSaida,
			String retorno, String operacao,ArrayList<RetornoItemPasseGeral> retornoItemPasse) {
		super();
		this.numeroPasse = numeroPasse;
		this.cdItem = cdItem;
		this.dsItem = dsItem;
		this.dsCliFor = dsCliFor;
		this.dataInclusao = dataInclusao;
		this.horaInclusao = horaInclusao;
		this.quantidade = quantidade;
		this.unidMed = unidMed;
		this.qtdeRetorno = qtdeRetorno;
		this.saldo = saldo;
		this.pesoLiquido = pesoLiquido;
		this.pesoBruto = pesoBruto;
		this.numeroVolumes = numeroVolumes;
		this.obs1 = obs1;
		this.obs2 = obs2;
		this.obs3 = obs3;
		this.valorUnitario = valorUnitario;
		this.valorOrcado = valorOrcado;
		this.statusPasse = statusPasse;
		this.entradaSaida = entradaSaida;
		this.retorno = retorno;
		this.operacao = operacao;
		this.retornoItemPasse = retornoItemPasse;
	}

	public ArrayList<RetornoItemPasseGeral> getRetornoItemPasse() {
		return retornoItemPasse;
	}

	public void setRetornoItemPasse(ArrayList<RetornoItemPasseGeral> retornoItemPasse) {
		this.retornoItemPasse = retornoItemPasse;
	}

	public String getNumeroPasse() {
		return numeroPasse;
	}

	public void setNumeroPasse(String numeroPasse) {
		this.numeroPasse = numeroPasse;
	}

	public String getCdItem() {
		return cdItem;
	}

	public void setCdItem(String cdItem) {
		this.cdItem = cdItem;
	}

	public String getDsItem() {
		return dsItem;
	}

	public void setDsItem(String dsItem) {
		this.dsItem = dsItem;
	}

	public String getDsCliFor() {
		return dsCliFor;
	}

	public void setDsCliFor(String dsCliFor) {
		this.dsCliFor = dsCliFor;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getHoraInclusao() {
		return horaInclusao;
	}

	public void setHoraInclusao(String horaInclusao) {
		this.horaInclusao = horaInclusao;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidMed() {
		return unidMed;
	}

	public void setUnidMed(String unidMed) {
		this.unidMed = unidMed;
	}

	public Float getQtdeRetorno() {
		return qtdeRetorno;
	}

	public void setQtdeRetorno(Float qtdeRetorno) {
		this.qtdeRetorno = qtdeRetorno;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Float getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(Float pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public Float getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(Float pesoBruto) {
		this.pesoBruto = pesoBruto;
	}

	public Integer getNumeroVolumes() {
		return numeroVolumes;
	}

	public void setNumeroVolumes(Integer numeroVolumes) {
		this.numeroVolumes = numeroVolumes;
	}

	public String getObs1() {
		return obs1;
	}

	public void setObs1(String obs1) {
		this.obs1 = obs1;
	}

	public String getObs2() {
		return obs2;
	}

	public void setObs2(String obs2) {
		this.obs2 = obs2;
	}

	public String getObs3() {
		return obs3;
	}

	public void setObs3(String obs3) {
		this.obs3 = obs3;
	}

	public Float getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Float getValorOrcado() {
		return valorOrcado;
	}

	public void setValorOrcado(Float valorOrcado) {
		this.valorOrcado = valorOrcado;
	}

	public String getStatusPasse() {
		return statusPasse;
	}

	public void setStatusPasse(String statusPasse) {
		this.statusPasse = statusPasse;
	}

	public String getEntradaSaida() {
		return entradaSaida;
	}

	public void setEntradaSaida(String entradaSaida) {
		this.entradaSaida = entradaSaida;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdItem == null) ? 0 : cdItem.hashCode());
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
		ItemPasseGeral other = (ItemPasseGeral) obj;
		if (cdItem == null) {
			if (other.cdItem != null)
				return false;
		} else if (!cdItem.equals(other.cdItem))
			return false;
		if (numeroPasse == null) {
			if (other.numeroPasse != null)
				return false;
		} else if (!numeroPasse.equals(other.numeroPasse))
			return false;
		return true;
	}
	
	

}
