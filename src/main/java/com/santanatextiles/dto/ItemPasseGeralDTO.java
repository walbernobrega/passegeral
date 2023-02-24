package com.santanatextiles.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.domain.ItemPasseGeral;

import jakarta.validation.constraints.NotEmpty;


public class ItemPasseGeralDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String idfil;
	
	private String numeroPasse;
	
	@NotEmpty(message="Código do Item é Obrigatório")
	private String codigoItem;
	
	private String dsItem;
	
	@JsonFormat(pattern="dd/MM/yyyy")
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
	
	private Set<RetornoItemPasseGeralDTO> retornoItensPasseDTO = new HashSet<>();
	
	public ItemPasseGeralDTO() {
		
	}
	
	public ItemPasseGeralDTO(ItemPasseGeral obj) {
		this.idfil = obj.getIdfil();
		this.numeroPasse = obj.getNumeroPasse(); 
		this.codigoItem = obj.getCdItem(); 
		this.dataInclusao = obj.getDataInclusao();
		this.horaInclusao = obj.getHoraInclusao(); 
		this.quantidade = obj.getQuantidade(); 
		this.unidMed = obj.getUnidMed(); 
		this.qtdeRetorno = obj.getQtdeRetorno();
		this.saldo = obj.getSaldo();
		this.pesoLiquido = obj.getPesoLiquido();
		this.pesoBruto = obj.getPesoBruto(); 
		this.numeroVolumes = obj.getNumeroVolumes(); 
		this.obs1 = obj.getObs1(); 
		this.obs2 = obj.getObs2(); 
		this.obs3 = obj.getObs3(); 
		this.valorUnitario = obj.getValorUnitario();
		this.valorOrcado = obj.getValorOrcado();
		this.retornoItensPasseDTO = obj.getRetornoItensPasseDTO();
	}

	public ItemPasseGeralDTO(String idfil, String numeroPasse, String codigoItem, String dsItem, Date dataInclusao,
			String horaInclusao, Float quantidade, String unidMed, Float qtdeRetorno, Float saldo, Float pesoLiquido,
			Float pesoBruto, Integer numeroVolumes, String obs1, String obs2, String obs3, Float valorUnitario,
			Float valorOrcado) {
		super();
		this.idfil = idfil;
		this.numeroPasse = numeroPasse;
		this.codigoItem = codigoItem;
		this.dsItem = dsItem;
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

	public String getDsItem() {
		return dsItem;
	}

	public void setDsItem(String dsItem) {
		this.dsItem = dsItem;
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

	public Set<RetornoItemPasseGeralDTO> getRetornoItensPasseDTO() {
		return retornoItensPasseDTO;
	}

	public void setRetornoItensPasseDTO(Set<RetornoItemPasseGeralDTO> retornoItensPasseDTO) {
		this.retornoItensPasseDTO = retornoItensPasseDTO;
	}

	

}
