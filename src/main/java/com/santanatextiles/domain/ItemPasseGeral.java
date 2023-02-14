package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="BALJ1_DBF", schema="BAL")
@IdClass(ItemPasseGeralId.class)
public class ItemPasseGeral implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDFIL")
	private String idfil;
	
	@Id
	@Column(name="J1COD")
	private String numeroPasse;
	
	@Id
	@Column(name="J1ITEM")
    private String codigoItem;
	
	@Column(name="J1DESC")
	private String dsItem;
	
	@Transient
	private String dsCliFor;
	
	@Column(name="J1DATA")
	private Date dataInclusao;
	
	@Column(name="J1HORA")
	private String horaInclusao;
	
	@Column(name="J1QTDE")
	private Float quantidade;
	
	@Column(name="J1UNID")
	private String unidMed;
	
	@Column(name="J1QTRET")
	private Float qtdeRetorno;
	
	@Column(name="J1SALDO")
	private Float saldo;
	
	@Column(name="J1PLIQ")
	private Float pesoLiquido;
	
	@Column(name="J1PBRU")
	private Float pesoBruto;
	
	@Column(name="J1VOLU")
	private Integer numeroVolumes;
	
	@Column(name="J1OBS1")
	private String obs1;
	
	@Column(name="J1OBS2")
	private String obs2;
	
	@Column(name="J1OBS3")
	private String obs3;
	
	@Column(name="J1PRUN")
	private Float valorUnitario;
	
	@Column(name="J1VUOR")
	private Float valorOrcado;
	
	@Transient
	private String statusPasse;
	
	@Transient
	private String entradaSaida;
	
	@Transient
	private String retorno;
	
	@Transient
	private String operacao;
	
	@OneToMany(mappedBy="itemPasseGeral", cascade=CascadeType.ALL)
	private Set<RetornoItemPasseGeral> retornoItemPasse = new HashSet<>();

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j1cod", referencedColumnName="j0cod", insertable = false, updatable = false)
	})
	private PasseGeral passeGeral;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="D0003_ID_LOCALIZACAO", insertable = false, updatable = false),
	    @JoinColumn(name="j1item", referencedColumnName="D0422_ID_ITEM", insertable = false, updatable = false)
	})
	private Item item;

	public ItemPasseGeral() {
		
	}

	public ItemPasseGeral(String idfil, String numeroPasse, String codigoItem,
			String dsItem, String dsCliFor, Date dataInclusao, String horaInclusao, Float quantidade, String unidMed,
			Float qtdeRetorno, Float saldo, Float pesoLiquido, Float pesoBruto, Integer numeroVolumes, String obs1,
			String obs2, String obs3, Float valorUnitario, Float valorOrcado, String statusPasse, String entradaSaida,
			String retorno, String operacao,PasseGeral passeGeral,Item item) {
		super();
		this.idfil = idfil;
		this.numeroPasse = numeroPasse;
		this.codigoItem = codigoItem;
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
		this.passeGeral = passeGeral;
		this.item = item;
	}

	public Set<RetornoItemPasseGeral> getRetornoItemPasse() {
		return retornoItemPasse;
	}
	
	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public void setRetornoItemPasse(Set<RetornoItemPasseGeral> retornoItemPasse) {
		this.retornoItemPasse = retornoItemPasse;
	}

	public String getNumeroPasse() {
		return numeroPasse;
	}

	public void setNumeroPasse(String numeroPasse) {
		this.numeroPasse = numeroPasse;
	}

	public String getCdItem() {
		return codigoItem;
	}

	public void setCdItem(String codigoItem) {
		this.codigoItem = codigoItem;
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

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public PasseGeral getPasseGeral() {
		return passeGeral;
	}

	public void setPasseGeral(PasseGeral passeGeral) {
		this.passeGeral = passeGeral;
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
