package com.santanatextiles.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.services.validation.PasseGeralValidation;

import jakarta.validation.constraints.NotEmpty;

@PasseGeralValidation
public class PasseGeralDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String idfil;

	private String numeroPasse;

	private String retorno;
	
	private String obs1;
	
	private String obs2;
	
	private String obs3;
	
	private String entradaSaida;
	
	private String cdCCusto;
	
	private String cdAutor;
	
	@NotEmpty(message="Cliente/Fornecedor é Obrigatório")
	private String cdFornCli;
	
	private String tpFornCli;
	
	@NotEmpty(message="Transação é Obrigatória")
	private String cdTransacao;
	
	private String notaFiscal;
	
	private String tipoTransporte;
	
	private String placa;
	
	private String cdTransportador;
	
	private String cdPorteiro;
	
	private String cdAprovador;
	
	private String tipoDocumento;
	
	private String numDocumento;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataVerificacao;

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInclusao;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataPrevisaoRetorno;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataProrrogacao;
	
	private String motivo;
	
	private String horaVerificacao;
	
	private String status;
	
	private String portador;
	
	private Set<ItemPasseGeralDTO> itensPasseDTO = new HashSet<>();

	public PasseGeralDTO() {
		
	}
	
	public PasseGeralDTO(PasseGeral obj) {
		this.idfil = obj.getIdfil();
		this.numeroPasse = obj.getNumeroPasse();
		this.retorno = obj.getRetorno().getCodigo();
		this.obs1 = obj.getObs1();
		this.obs2 = obj.getObs2();
		this.obs3 = obj.getObs3();
		this.entradaSaida = obj.getEntradaSaida().getCodigo();
		this.cdCCusto = obj.getCdCCusto();
		this.cdAutor = obj.getCdAutor();
		this.cdFornCli = obj.getCdFornCli();
		this.tpFornCli = obj.getTpFornCli().getCodigo();
		this.cdTransacao = obj.getCdTransacao();
		this.notaFiscal = obj.getNotaFiscal();
		this.tipoTransporte = obj.getTipoTransporte();
		this.placa = obj.getPlaca();
		this.cdTransportador = obj.getCdTransportador();
		this.cdPorteiro = obj.getCdPorteiro();
		this.cdAprovador = obj.getCdAprovador();
		this.tipoDocumento = obj.getTipoDocumento();
		this.numDocumento = obj.getNumDocumento();
		this.dataVerificacao = obj.getDataVerificacao();
		this.dataInclusao = obj.getDataInclusao();
		this.dataPrevisaoRetorno = obj.getDataPrevisaoRetorno();
		this.dataProrrogacao = obj.getDataProrrogacao();
		this.motivo = obj.getMotivo();
		this.horaVerificacao = obj.getHoraVerificacao();
		this.status = obj.getStatus();
		this.portador = obj.getPortador();
		this.itensPasseDTO = obj.getItensPasseDTO();
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

	public String getRetorno() {
		return retorno;
	}

	public void setRetorno(String retorno) {
		this.retorno = retorno;
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

	public String getCdAutor() {
		return cdAutor;
	}

	public void setCdAutor(String cdAutor) {
		this.cdAutor = cdAutor;
	}

	public String getCdFornCli() {
		return cdFornCli;
	}

	public void setCdFornCli(String cdFornCli) {
		this.cdFornCli = cdFornCli;
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

	public String getCdPorteiro() {
		return cdPorteiro;
	}

	public void setCdPorteiro(String cdPorteiro) {
		this.cdPorteiro = cdPorteiro;
	}

	public String getCdAprovador() {
		return cdAprovador;
	}

	public void setCdAprovador(String cdAprovador) {
		this.cdAprovador = cdAprovador;
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

	public Set<ItemPasseGeralDTO> getItensPasseDTO() {
		return itensPasseDTO;
	}

	public void setItensPasse(Set<ItemPasseGeralDTO> itensPasseDTO) {
		this.itensPasseDTO = itensPasseDTO;
	}

	
}
