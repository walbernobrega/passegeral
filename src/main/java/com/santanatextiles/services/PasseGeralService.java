package com.santanatextiles.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.CentroDeCusto;
import com.santanatextiles.domain.Cliente;
import com.santanatextiles.domain.Fornecedor;
import com.santanatextiles.domain.Gerente;
import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.domain.PasseGeralId;
import com.santanatextiles.domain.Porteiro;
import com.santanatextiles.domain.Transacao;
import com.santanatextiles.domain.Transportadora;
import com.santanatextiles.domain.UsuarioPasse;
import com.santanatextiles.domain.enums.TipoDestino;
import com.santanatextiles.dto.PasseGeralDTO;
import com.santanatextiles.repositories.PasseGeralRepository;
import com.santanatextiles.services.exceptions.DataIntegrityException;
import com.santanatextiles.services.exceptions.ObjectNotFoundException;


@Service
public class PasseGeralService {

	@Autowired
	private PasseGeralRepository repo;
	
	@Autowired
	private TransacaoService transacaoService;

	@Autowired
	private CentroDeCustoService centroDeCustoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private FornecedorService fornecedorService;

	@Autowired
	private PorteiroService porteiroService;

	@Autowired
	private UsuarioPasseService usuarioPasseService;

	@Autowired
	private TransportadoraService transportadoraService;

	@Autowired
	private GerenteService gerenteService;
	
	
	public PasseGeral buscar(String idfil , String numeroPasse) {
		Optional<PasseGeral> obj = repo.findById(new PasseGeralId(PassegeralApplication._EMPRESA,numeroPasse));
		if (obj == null) {
			throw new ObjectNotFoundException("Passe Não Encontrado.");
		}
		return obj.orElse(null);
	}
	
	@Transactional
	public PasseGeral insert(PasseGeral obj) {
		String novoCodigo = repo.CodigoNovoPasse(PassegeralApplication._EMPRESA);
		obj.setIdfil(PassegeralApplication._EMPRESA);
		obj.setNumeroPasse(novoCodigo);
		return repo.save(obj);
	}

	@Transactional
	public PasseGeral update(PasseGeral obj) {
		List<String> msg = verificaEntidades(obj);
		if (msg.isEmpty()) {
			buscar(PassegeralApplication._EMPRESA,obj.getNumeroPasse());
		} else {
			throw new DataIntegrityException(String.join(",", msg)); 
		}
		return repo.save(obj);
		
	}
	
	private List<String> verificaEntidades(PasseGeral obj) {
		ArrayList<String> msg = new ArrayList<>();
		try {
			if(obj.getCdTransacao() != null) {
				Transacao transacao = transacaoService.buscar(PassegeralApplication._EMPRESA,obj.getCdTransacao()); 
				if ( transacao == null) {
					msg.add("Transação Não Cadastrada");
				} else {
					obj.setTransacao(transacao);
				};
			}
			if(obj.getCdTransportador() != null) {
				Transportadora transportadora = transportadoraService.buscar(PassegeralApplication._EMPRESA,obj.getCdTransportador()); 
				if ( transportadora == null) {
					msg.add("Tranportadora Não Cadastrada");
				} else {
					obj.setTransportadora(transportadora);
				};
			}
			if(obj.getCdPorteiro() != null) {
				Porteiro porteiro = porteiroService.buscar(PassegeralApplication._EMPRESA,obj.getCdPorteiro()); 
				if (  porteiro == null) {
					msg.add("Porteiro Não Cadastrado");
				} else {
					obj.setPorteiro(porteiro);
				};
			}
			if(obj.getCdFornCli() != null) {
				if (obj.getTpFornCli().equals(TipoDestino.CLIENTE)) {
					Cliente cli = clienteService.buscar(PassegeralApplication._EMPRESA,obj.getCdFornCli());
					if ( cli == null) {
						msg.add("Cliente Não Cadastrado");
					} else {
						obj.setCliente(cli);
					};
				}
				if (obj.getTpFornCli().equals(TipoDestino.FORNECEDOR)) {
					Fornecedor fornecedor = fornecedorService.buscar(PassegeralApplication._EMPRESA,obj.getCdFornCli()); 
					if (  fornecedor == null) {
						msg.add("Fornecedor Não Cadastrado");
					} else {
						obj.setFornecedor(fornecedor);
					};
				}
			}
			if(obj.getCdAutor() != null) {
				UsuarioPasse usuarioPasse = usuarioPasseService.buscar(PassegeralApplication._EMPRESA,obj.getCdAprovador()); 
				if ( usuarioPasse == null) {
					msg.add("Usuário Não Cadastrado");
				} else {
					obj.setUsuarioPasse(usuarioPasse);
				};
			}
			if(obj.getCdCCusto() != null) {
				CentroDeCusto centroDeCusto = centroDeCustoService.buscar(PassegeralApplication._EMPRESA,obj.getCdCCusto()); 
				if ( centroDeCusto == null) {
					msg.add("Centro de Custo Não Cadastrado");
				} else {
					obj.setCentroDeCusto(centroDeCusto);
				};
			}
			if(obj.getCdAprovador() != null) {
				Gerente gerente = gerenteService.buscar(PassegeralApplication._EMPRESA,obj.getCdAprovador()); 
				if ( gerente == null) {
					msg.add("Gerente Não Cadastrado");
				} else {
					obj.setGerente(gerente);
				};
			}
		} 
		catch (Exception e) {
			
		}
		return msg;
	}

	@Transactional
	public void delete(String numeroPasse) {
		try {
			buscar(PassegeralApplication._EMPRESA, numeroPasse);
			repo.deletaRetornoItensPasseGeral(PassegeralApplication._EMPRESA,numeroPasse);
			repo.deletaItensPasseGeral(PassegeralApplication._EMPRESA,numeroPasse);
			repo.deletaPasseGeral(PassegeralApplication._EMPRESA,numeroPasse);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Erro de Violação de Integridade");
		}
	}
	
	public Page<PasseGeral> listagemGeral(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findByIdfilOrderByDataInclusao(pageRequest,PassegeralApplication._EMPRESA);
	}
	
	public List<PasseGeral> procuraPorPortador(String idfil, String portador) {
		return repo.findByIdfilAndPortadorContainingIgnoreCaseOrderByPortador(idfil, portador);
	}

	public Page<PasseGeral> passesNaoVerificados(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.passesNaoVerificados(pageRequest, idfil);
	}
	
	public Page<PasseGeral> passesNaoAprovados(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil, String gerente) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.passesNaoAprovados(pageRequest, idfil, gerente);
	}

	public Page<PasseGeral> passesDoUsuario(Integer page, Integer linesPerPage, String orderBy, String direction, String idfil, String autor) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.passesDoUsuario(pageRequest, idfil, autor);
	}

	public PasseGeral fromDTO(PasseGeralDTO objDTO) {
		return new PasseGeral(
				objDTO.getIdfil(),
				objDTO.getNumeroPasse(),
				objDTO.getRetorno(),
				objDTO.getObs1(),
				objDTO.getObs2(),
				objDTO.getObs3(),
				objDTO.getEntradaSaida(),
				objDTO.getCdCCusto(),
				objDTO.getCdAutor(),
				objDTO.getCdFornCli(),
				objDTO.getTpFornCli(),
				objDTO.getCdTransacao(),
				objDTO.getNotaFiscal(),
				objDTO.getTipoTransporte(),
				objDTO.getPlaca(),
				objDTO.getCdTransportador(),
				objDTO.getCdPorteiro(),
				objDTO.getCdAprovador(),
				objDTO.getTipoDocumento(),
				objDTO.getNumDocumento(),
				objDTO.getDataVerificacao(),
				objDTO.getDataInclusao(),
				objDTO.getDataPrevisaoRetorno(),
				objDTO.getDataProrrogacao(),
				objDTO.getMotivo(),
				objDTO.getHoraVerificacao(),
				objDTO.getStatus(),
				objDTO.getPortador()
				);
	}

}
