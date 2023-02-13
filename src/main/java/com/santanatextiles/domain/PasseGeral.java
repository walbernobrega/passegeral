package com.santanatextiles.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;


@Entity
@Table(name="BALJ0_DBF", schema="BAL")
@IdClass(PasseGeralId.class)
public class PasseGeral implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDFIL")
	private String idfil;

	@Id
	@Column(name="J0COD")
	private String numeroPasse;
	
	@Column(name="J0RETO")
	private String retorno;
	
	@Column(name="J0OBS1")
	private String obs1;
	@Column(name="J0OBS2")
	private String obs2;
	@Column(name="J0OBS3")
	private String obs3;
	@Column(name="J0ENSA")
	private String entradaSaida;
	@Column(name="J0CECU")
	private String cdCCusto;

	@Transient
	private String dsCCusto;
	
	@Column(name="J0AUTOR")
	private String cdAutor;
	
	@Transient
	private String dsAutor;
	
	@Column(name="J0DEST")
	private String cdFornCli;
	
	@Transient
	private String dsFornCli;
	
	@Column(name="J0TPDEST")
	private String tpFornCli;
	
	@Column(name="J0TRSA")
	private String cdTransacao;
	
	@Transient
	private String dsTransacao;

	@Transient
	private String aprovador;
	
	@Column(name="J0NOTA")
	private String notaFiscal;
	
	@Column(name="J0PTFN")
	private String tipoTransporte;
	
	@Column(name="J0PLAC")
	private String placa;
	
	@Column(name="J0TRAN")
	private String cdTransportador;
	
	@Transient
	private String dsTransportador;
	
	@Column(name="J0PORT")
	private String cdPorteiro;
	
	@Transient
	private String dsPorteiro;
	
	@Column(name="J0GEREN")
	private String cdAprovador;
	
	@Transient
	private String dsAprovador;
	
	@Column(name="J0TPDC")
	private String tipoDocumento;
	
	@Column(name="J0DOCT")
	private String numDocumento;
	
	@Column(name="J0DATA")
	private Date dataVerificacao;
	
	@Column(name="J0DTIN")
	private Date dataInclusao;
	
	@Column(name="J0RETORNO")
	private Date dataPrevisaoRetorno;
	
	@Column(name="J0PRORROGA")
	private Date dataProrrogacao;
	
	@Column(name="J0MOTIVO")
	private String motivo;
	
	@Column(name="J0HORA")
	private String horaVerificacao;
	
	@Column(name="J0STAT")
	private String status;
	
	@Column(name="J0PORTADOR")
	private String portador;

	@JsonManagedReference
	@OneToMany(mappedBy="passeGeral", cascade=CascadeType.ALL)
	private List<ItemPasseGeral> itensPasse = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j0trsa", referencedColumnName="f6cod", insertable = false, updatable = false)
	})
	private Transacao transacao;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j0tran", referencedColumnName="b2cod", insertable = false, updatable = false)
	})
	private Transportadora transportadora;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j0cecu", referencedColumnName="d4cod", insertable = false, updatable = false)
	})
	private CentroDeCusto centroDeCusto;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j0autor", referencedColumnName="d4matr", insertable = false, updatable = false)
	})
	private UsuarioPasse usuarioPasse;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j0geren", referencedColumnName="c3matr", insertable = false, updatable = false)
	})
	private Gerente gerente;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j0port", referencedColumnName="e5cod", insertable = false, updatable = false)
	})
	private Porteiro porteiro;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j0dest", referencedColumnName="b2cod", insertable = false, updatable = false),
	    @JoinColumn(name="j0tpdest", referencedColumnName="b2tpentida", insertable = false, updatable = false),
	})
	private Cliente cliente;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumns({
	    @JoinColumn(name="idfil", referencedColumnName="idfil", insertable = false, updatable = false),
	    @JoinColumn(name="j0dest", referencedColumnName="b2cod", insertable = false, updatable = false),
	    @JoinColumn(name="j0tpdest", referencedColumnName="b2tpentida", insertable = false, updatable = false),
	})
	private Fornecedor fornecedor;
	
	public PasseGeral() {
		
	}

	public PasseGeral(String idfil, String retorno, String numeroPasse, String obs1, String obs2, String obs3,
			String entradaSaida, String cdCCusto, String dsCCusto, String cdAutor, String dsAutor, String cdFornCli,
			String dsFornCli, String tpFornCli, String cdTransacao, String dsTransacao, String aprovador,
			String notaFiscal, String tipoTransporte, String placa, String cdTransportador, String dsTransportador,
			String cdPorteiro, String dsPorteiro, String cdAprovador, String dsAprovador, String tipoDocumento,
			String numDocumento, Date dataVerificacao, Date dataInclusao, Date dataPrevisaoRetorno,
			Date dataProrrogacao, String motivo, String horaVerificacao, String status, String portador,
			Transacao transacao, Transportadora transportadora, CentroDeCusto centroDeCusto, UsuarioPasse usuarioPasse,
			Gerente gerente, Porteiro porteiro,Cliente cliente, Fornecedor fornecedor) {
		super();
		this.idfil = idfil;
		this.retorno = retorno;
		this.numeroPasse = numeroPasse;
		this.obs1 = obs1;
		this.obs2 = obs2;
		this.obs3 = obs3;
		this.entradaSaida = entradaSaida;
		this.cdCCusto = cdCCusto;
		this.dsCCusto = dsCCusto;
		this.cdAutor = cdAutor;
		this.dsAutor = dsAutor;
		this.cdFornCli = cdFornCli;
		this.dsFornCli = dsFornCli;
		this.tpFornCli = tpFornCli;
		this.cdTransacao = cdTransacao;
		this.dsTransacao = dsTransacao;
		this.aprovador = aprovador;
		this.notaFiscal = notaFiscal;
		this.tipoTransporte = tipoTransporte;
		this.placa = placa;
		this.cdTransportador = cdTransportador;
		this.dsTransportador = dsTransportador;
		this.cdPorteiro = cdPorteiro;
		this.dsPorteiro = dsPorteiro;
		this.cdAprovador = cdAprovador;
		this.dsAprovador = dsAprovador;
		this.tipoDocumento = tipoDocumento;
		this.numDocumento = numDocumento;
		this.dataVerificacao = dataVerificacao;
		this.dataInclusao = dataInclusao;
		this.dataPrevisaoRetorno = dataPrevisaoRetorno;
		this.dataProrrogacao = dataProrrogacao;
		this.motivo = motivo;
		this.horaVerificacao = horaVerificacao;
		this.status = status;
		this.portador = portador;
		this.transacao = transacao;
		this.transportadora = transportadora;
		this.centroDeCusto = centroDeCusto;
		this.usuarioPasse = usuarioPasse;
		this.gerente = gerente;
		this.porteiro = porteiro;
		this.cliente = cliente;
		this.fornecedor = fornecedor;
	}

	public String getIdfil() {
		return idfil;
	}

	public void setIdfil(String idfil) {
		this.idfil = idfil;
	}

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	public String getNumeroPasse() {
		return numeroPasse;
	}

	public void setNumeroPasse(String numeroPasse) {
		this.numeroPasse = numeroPasse;
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

	public String getEntradaSaida() {
		return entradaSaida;
	}

	public void setEntradaSaida(String entradaSaida) {
		this.entradaSaida = entradaSaida;
	}

	public String getCdCCusto() {
		return cdCCusto;
	}

	public void setCdCCusto(String cdCCusto) {
		this.cdCCusto = cdCCusto;
	}

	public String getDsCCusto() {
		return dsCCusto;
	}

	public void setDsCCusto(String dsCCusto) {
		this.dsCCusto = dsCCusto;
	}

	public String getCdAutor() {
		return cdAutor;
	}

	public void setCdAutor(String cdAutor) {
		this.cdAutor = cdAutor;
	}

	public String getDsAutor() {
		return dsAutor;
	}

	public void setDsAutor(String dsAutor) {
		this.dsAutor = dsAutor;
	}

	public String getCdFornCli() {
		return cdFornCli;
	}

	public void setCdFornCli(String cdFornCli) {
		this.cdFornCli = cdFornCli;
	}

	public String getDsFornCli() {
		return dsFornCli;
	}

	public void setDsFornCli(String dsFornCli) {
		this.dsFornCli = dsFornCli;
	}

	public String getTpFornCli() {
		return tpFornCli;
	}

	public void setTpFornCli(String tpFornCli) {
		this.tpFornCli = tpFornCli;
	}

	public String getCdTransacao() {
		return cdTransacao;
	}

	public void setCdTransacao(String cdTransacao) {
		this.cdTransacao = cdTransacao;
	}

	public String getDsTransacao() {
		return dsTransacao;
	}

	public void setDsTransacao(String dsTransacao) {
		this.dsTransacao = dsTransacao;
	}

	public String getAprovador() {
		return aprovador;
	}

	public void setAprovador(String aprovador) {
		this.aprovador = aprovador;
	}

	public String getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCdTransportador() {
		return cdTransportador;
	}

	public void setCdTransportador(String cdTransportador) {
		this.cdTransportador = cdTransportador;
	}

	public String getDsTransportador() {
		return dsTransportador;
	}

	public void setDsTransportador(String dsTransportador) {
		this.dsTransportador = dsTransportador;
	}

	public String getCdPorteiro() {
		return cdPorteiro;
	}

	public void setCdPorteiro(String cdPorteiro) {
		this.cdPorteiro = cdPorteiro;
	}

	public String getDsPorteiro() {
		return dsPorteiro;
	}

	public void setDsPorteiro(String dsPorteiro) {
		this.dsPorteiro = dsPorteiro;
	}

	public String getCdAprovador() {
		return cdAprovador;
	}

	public void setCdAprovador(String cdAprovador) {
		this.cdAprovador = cdAprovador;
	}

	public String getDsAprovador() {
		return dsAprovador;
	}

	public void setDsAprovador(String dsAprovador) {
		this.dsAprovador = dsAprovador;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumDocumento() {
		return numDocumento;
	}

	public void setNumDocumento(String numDocumento) {
		this.numDocumento = numDocumento;
	}

	public Date getDataVerificacao() {
		return dataVerificacao;
	}

	public void setDataVerificacao(Date dataVerificacao) {
		this.dataVerificacao = dataVerificacao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataPrevisaoRetorno() {
		return dataPrevisaoRetorno;
	}

	public void setDataPrevisaoRetorno(Date dataPrevisaoRetorno) {
		this.dataPrevisaoRetorno = dataPrevisaoRetorno;
	}

	public Date getDataProrrogacao() {
		return dataProrrogacao;
	}

	public void setDataProrrogacao(Date dataProrrogacao) {
		this.dataProrrogacao = dataProrrogacao;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getHoraVerificacao() {
		return horaVerificacao;
	}

	public void setHoraVerificacao(String horaVerificacao) {
		this.horaVerificacao = horaVerificacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPortador() {
		return portador;
	}

	public void setPortador(String portador) {
		this.portador = portador;
	}

	public List<ItemPasseGeral> getItensPasse() {
		return itensPasse;
	}

	public void setItensPasse(ArrayList<ItemPasseGeral> itensPasse) {
		this.itensPasse = itensPasse;
	}

	public Transacao getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}

	
	public Transportadora getTransportadora() {
		return transportadora;
	}

	public void setTransportadora(Transportadora transportadora) {
		this.transportadora = transportadora;
	}

	
	public CentroDeCusto getCentroDeCusto() {
		return centroDeCusto;
	}

	public void setCentroDeCusto(CentroDeCusto centroDeCusto) {
		this.centroDeCusto = centroDeCusto;
	}

	public UsuarioPasse getUsuarioPasse() {
		return usuarioPasse;
	}

	public void setUsuarioPasse(UsuarioPasse usuarioPasse) {
		this.usuarioPasse = usuarioPasse;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public Porteiro getPorteiro() {
		return porteiro;
	}

	public void setPorteiro(Porteiro porteiro) {
		this.porteiro = porteiro;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		PasseGeral other = (PasseGeral) obj;
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
