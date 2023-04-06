package com.santanatextiles.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.domain.PasseGeralId;

@Repository
public interface PasseGeralRepository extends JpaRepository<PasseGeral , PasseGeralId> {
	
	@Transactional(readOnly=true)
	Page<PasseGeral> findByIdfilOrderByDataInclusao(PageRequest pageRequest, String idfil);

	@Query("SELECT p "
			+ "FROM PasseGeral p, ItemPasseGeral i "
			+ "WHERE p.idfil = :idfil "
			+ "		and p.idfil = i.idfil "
			+ "		and p.numeroPasse = i.numeroPasse "
			+ "		and p.numeroPasse = :numeroPasse "
			+ "		and i.codigoItem = :codigoItem")
	PasseGeral buscaPasseItem(@Param("idfil") String idfil, @Param("numeroPasse") String numeroPasse,@Param("codigoItem")  String codigoItem);
	
	@Transactional(readOnly=true)
	List<PasseGeral> findByIdfilAndPortadorContainingIgnoreCaseOrderByPortador(String idfil, String portador);

	@Modifying
	@Query(value="DELETE FROM bal.balj2_dbf WHERE idfil = :idfil AND j2cod = :numeroPasse", nativeQuery = true)
	int deletaRetornoItensPasseGeral(@Param("idfil") String idfil,@Param("numeroPasse") String numeroPasse);

	@Modifying
	@Query(value="DELETE FROM bal.balj1_dbf WHERE idfil = :idfil AND j1cod = :numeroPasse", nativeQuery = true)
	int deletaItensPasseGeral(@Param("idfil") String idfil,@Param("numeroPasse") String numeroPasse);

	@Modifying
	@Query(value="DELETE FROM bal.balj0_dbf WHERE idfil = :idfil AND j0cod = :numeroPasse", nativeQuery = true)
	int deletaPasseGeral(@Param("idfil") String idfil,@Param("numeroPasse") String numeroPasse);

	@Modifying
	@Query(value="UPDATE bal.balj0_dbf SET J0GEREN=:gerente WHERE idfil = :idfil AND j0cod = :numeroPasse", nativeQuery = true)
	int aprovaPasseGeral(@Param("idfil") String idfil,@Param("numeroPasse") String numeroPasse,@Param("gerente") String gerente);

	@Modifying
	@Query(value="UPDATE bal.balj0_dbf SET J0GEREN=null WHERE idfil = :idfil AND j0cod = :numeroPasse", nativeQuery = true)
	int desaprovaPasseGeral(@Param("idfil") String idfil,@Param("numeroPasse") String numeroPasse);

	@Modifying
	@Query(value="UPDATE bal.balj0_dbf SET "
			+ "J0DATA=:data,"
			+ "J0HORA=:hora,"
			+ "J0PORT=:porteiro,"
			+ "J0TRAN=:transportadora,"
			+ "J0PTFN=:tipoTransporte,"
			+ "J0PLAC=:placa"
			+ " WHERE idfil = :idfil AND j0cod = :numeroPasse", nativeQuery = true)
	int verificaPasseGeral(
			@Param("idfil") String idfil,
			@Param("numeroPasse") String numeroPasse,
			@Param("data") Date data,
			@Param("hora") String hora,
			@Param("porteiro") String porteiro,
			@Param("transportadora") String transportadora,
			@Param("tipoTransporte") String tipoTransporte,
			@Param("placa") String placa
			);

	@Modifying
	@Query(value="UPDATE bal.balj0_dbf SET "
			+ "J0DATA=null,"
			+ "J0HORA=null,"
			+ "J0PORT=null,"
			+ "J0TRAN=null,"
			+ "J0PLAC=null"
			+ " WHERE idfil = :idfil AND j0cod = :numeroPasse", nativeQuery = true)
	int desverificaPasseGeral(@Param("idfil") String idfil,@Param("numeroPasse") String numeroPasse);

	@Modifying
	@Query(value="UPDATE bal.balj0_dbf SET "
			+ "J0PRORROGA=:data,"
			+ "J0MOTIVO=:motivo"
			+ " WHERE idfil = :idfil AND j0cod = :numeroPasse", nativeQuery = true)
	int prorrogaPasseGeral(
			@Param("idfil") String idfil,
			@Param("numeroPasse") String numeroPasse,
			@Param("data") Date data,
			@Param("motivo") String motivo
			);
	
	@Modifying
	@Query(value="UPDATE bal.balj0_dbf SET J0NOTA=:nota WHERE idfil = :idfil AND j0cod = :numeroPasse", nativeQuery = true)
	int lancaNotaPasseGeral(@Param("idfil") String idfil,@Param("numeroPasse") String numeroPasse,@Param("nota") String nota);

	@Transactional(readOnly=true)
	@Query(value="SELECT  j0.j0dtin as j0dtin,"
			+ "        j0.idfil as idfil,"
			+ "        j0.j0cod as j0cod,"
			+ "        j0.j0geren as j0geren,"
			+ "        j0.j0autor as j0autor,"
			+ "        j0.j0cecu as j0cecu,"
			+ "        j0.j0dest as j0dest,"
			+ "        j0.j0trsa as j0trsa,"
			+ "        j0.j0tran as j0tran,"
			+ "        j0.j0tpdest as j0tpdest,"
			+ "        j0.j0retorno as j0retorno,"
			+ "        j0.j0prorroga as j0prorroga,"
			+ "        j0.j0data as j0data,"
			+ "        j0.j0hora as j0hora,"
			+ "        j0.j0ensa as j0ensa,"
			+ "        j0.j0motivo as j0motivo,"
			+ "        j0.j0nota as j0nota,"
			+ "        j0.j0doct as j0doct,"
			+ "        j0.j0obs1 as j0obs1,"
			+ "        j0.j0obs2 as j0obs2,"
			+ "        j0.j0obs3 as j0obs3,"
			+ "        j0.j0plac as j0plac,"
			+ "        j0.j0port as j0port,"
			+ "        j0.j0reto as j0reto,"
			+ "        j0.j0stat as j0stat,"
			+ "        j0.j0tpdc as j0tpdc,"
			+ "        j0.j0ptfn as j0ptfn,"
			+ "        f6.f6desc as dstransacao,"
			+ "        bal.status_passe(j0.j0cod, j0.idfil) as dsStatus,"
			+ "        DECODE(d4.d4apeli,NULL,c3.c3apeli,d4.d4apeli) as dsautor,"
			+ "        DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome) as entidade, "
			+ "        SUBSTR(DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome),1,30) as entidade_resumido,"
			+ "        j0.j0portador as j0portador"
			+ "  FROM  bal.balj0_dbf j0, "
			+ "        bal.balf6_dbf f6, "
			+ "        spc.spcd4_dbf d4, "
			+ "        spc.spcc3_dbf c3, "
			+ "        ccp.ccpb2_dbf f, "
			+ "        ccr.ccrb2_dbf c "
			+ "  WHERE j0.idfil = :idfil "
			+ "        AND f6.idfil = j0.idfil "
			+ "        AND j0.idfil = d4.idfil(+)"
			+ "        AND j0.idfil = c3.idfil(+)"
			+ "        AND j0.idfil = c.idfil(+)"
			+ "        AND j0.idfil = f.idfil(+)"
			+ "        AND j0.j0trsa = f6.f6cod "
			+ "        AND j0.j0autor = d4.d4matr(+) "
			+ "        AND j0.j0autor = c3.c3matr(+) "
			+ "        AND j0.j0ensa = 'S' "
			+ "        AND j0.j0geren is not null "
			+ "        AND j0.j0geren <> ' ' "
			+ "        AND j0.j0geren <> '00000' "
			+ "        AND (TO_CHAR(j0.j0data,'yyyy') = '4712' OR j0.j0data is NULL) "
			+ "        AND j0.j0dest = c.b2cod(+) "
			+ "        AND j0.j0dest = f.b2cod(+) ",
			countQuery = "SELECT COUNT(*)"
					+ "  FROM  bal.balj0_dbf j0, "
					+ "        bal.balf6_dbf f6, "
					+ "        spc.spcd4_dbf d4, "
					+ "        spc.spcc3_dbf c3, "
					+ "        ccp.ccpb2_dbf f, "
					+ "        ccr.ccrb2_dbf c "
					+ "  WHERE j0.idfil = :idfil "
					+ "        AND f6.idfil = j0.idfil "
					+ "        AND j0.idfil = d4.idfil(+)"
					+ "        AND j0.idfil = c3.idfil(+)"
					+ "        AND j0.idfil = c.idfil(+)"
					+ "        AND j0.idfil = f.idfil(+)"
					+ "        AND j0.j0trsa = f6.f6cod "
					+ "        AND j0.j0autor = d4.d4matr(+) "
					+ "        AND j0.j0autor = c3.c3matr(+) "
					+ "        AND j0.j0ensa = 'S' "
					+ "        AND j0.j0geren is not null "
					+ "        AND j0.j0geren <> ' ' "
					+ "        AND j0.j0geren <> '00000' "
					+ "        AND (TO_CHAR(j0.j0data,'yyyy') = '4712' OR j0.j0data is NULL) "
					+ "        AND j0.j0dest = c.b2cod(+) "
					+ "        AND j0.j0dest = f.b2cod(+) ",
			nativeQuery = true)
	Page<PasseGeral> passesNaoVerificados(PageRequest pageRequest, @Param("idfil") String idfil);

	@Query(value="SELECT LPAD(NVL(MAX(j0cod),0)+1,6,'0') FROM bal.balj0_dbf WHERE idfil = :idfil", nativeQuery = true)
	String CodigoNovoPasse(@Param("idfil") String idfil);
	
	@Transactional(readOnly=true)
	@Query(value="SELECT  j0.j0dtin as j0dtin,"
			+ "                 j0.idfil as idfil,"
			+ "                 j0.j0cod as j0cod,"
			+ "                 j0.j0geren as j0geren,"
			+ "                 j0.j0autor as j0autor,"
			+ "                 j0.j0cecu as j0cecu,"
			+ "                 j0.j0dest as j0dest,"
			+ "                 j0.j0trsa as j0trsa,"
			+ "                 j0.j0tran as j0tran,"
			+ "                 j0.j0tpdest as j0tpdest,"
			+ "                 j0.j0retorno as j0retorno,"
			+ "                 j0.j0prorroga as j0prorroga,"
			+ "                 j0.j0data as j0data,"
			+ "                 j0.j0hora as j0hora,"
			+ "                 j0.j0ensa as j0ensa,"
			+ "                 j0.j0motivo as j0motivo,"
			+ "                 j0.j0nota as j0nota,"
			+ "                 j0.j0doct as j0doct,"
			+ "                 j0.j0obs1 as j0obs1,"
			+ "                 j0.j0obs2 as j0obs2,"
			+ "                 j0.j0obs3 as j0obs3,"
			+ "                 j0.j0plac as j0plac,"
			+ "                 j0.j0port as j0port,"
			+ "                 j0.j0reto as j0reto,"
			+ "                 j0.j0stat as j0stat,"
			+ "                 j0.j0tpdc as j0tpdc,"
			+ "                 j0.j0ptfn as j0ptfn,"
			+ "        			bal.status_passe(j0.j0cod, j0.idfil) as dsStatus,"
			+ "                 f6.f6desc as dstransacao,"
			+ "                 DECODE(d4.d4apeli,NULL,c3.c3apeli,d4.d4apeli) as dsautor,"
			+ "                 DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome) as entidade, "
			+ "                 SUBSTR(DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome),1,30) as entidade_resumido,"
			+ "                 j0.j0portador as j0portador"
			+ "           FROM  bal.balj0_dbf j0, "
			+ "                 bal.balf6_dbf f6, "
			+ "                 spc.spcd4_dbf d4, "
			+ "                 spc.spcc3_dbf c3, "
			+ "                 ccp.ccpb2_dbf f, "
			+ "                 ccr.ccrb2_dbf c "
			+ "           WHERE j0.idfil = :idfil"
			+ "                 AND f6.idfil = j0.idfil "
			+ "                 AND j0.idfil = d4.idfil(+)"
			+ "                 AND j0.idfil = c3.idfil(+)"
			+ "                 AND j0.idfil = c.idfil(+)"
			+ "                 AND j0.idfil = f.idfil(+)"
			+ "                 AND j0.j0trsa = f6.f6cod "
			+ "                 AND j0.j0autor = d4.d4matr(+) "
			+ "                 AND j0.j0autor = c3.c3matr(+) "
			+ "                 AND (j0.j0geren is null OR j0.j0geren = ' ' OR j0.j0geren = '00000')"
			+ "                 AND (TO_CHAR(j0.j0data,'yyyy') = '4712' OR j0.j0data is NULL) "
			+ "                 AND SUBSTR(f6.f6geren,1,5) = :gerente"
			+ "                 AND j0.j0dest = c.b2cod(+) "
			+ "                 AND j0.j0dest = f.b2cod(+) ",
			countQuery = "SELECT COUNT(*)"
					+ "           FROM  bal.balj0_dbf j0, "
					+ "                 bal.balf6_dbf f6, "
					+ "                 spc.spcd4_dbf d4, "
					+ "                 spc.spcc3_dbf c3, "
					+ "                 ccp.ccpb2_dbf f, "
					+ "                 ccr.ccrb2_dbf c "
					+ "           WHERE j0.idfil = :idfil"
					+ "                 AND f6.idfil = j0.idfil "
					+ "                 AND j0.idfil = d4.idfil(+)"
					+ "                 AND j0.idfil = c3.idfil(+)"
					+ "                 AND j0.idfil = c.idfil(+)"
					+ "                 AND j0.idfil = f.idfil(+)"
					+ "                 AND j0.j0trsa = f6.f6cod "
					+ "                 AND j0.j0autor = d4.d4matr(+) "
					+ "                 AND j0.j0autor = c3.c3matr(+) "
					+ "                 AND (j0.j0geren is null OR j0.j0geren = ' ' OR j0.j0geren = '00000')"
					+ "                 AND (TO_CHAR(j0.j0data,'yyyy') = '4712' OR j0.j0data is NULL) "
					+ "                 AND SUBSTR(f6.f6geren,1,5) = :gerente"
					+ "                 AND j0.j0dest = c.b2cod(+) "
					+ "                 AND j0.j0dest = f.b2cod(+) ",
			nativeQuery = true)
	Page<PasseGeral> passesNaoAprovados(PageRequest pageRequest, @Param("idfil") String idfil, @Param("gerente") String gerente);

	@Transactional(readOnly=true)
	@Query(value="SELECT  j0.j0dtin as j0dtin,"
			+ "                 j0.idfil as idfil,"
			+ "                 j0.j0cod as j0cod,"
			+ "                 j0.j0geren as j0geren,"
			+ "                 j0.j0autor as j0autor,"
			+ "                 j0.j0cecu as j0cecu,"
			+ "                 j0.j0dest as j0dest,"
			+ "                 j0.j0trsa as j0trsa,"
			+ "                 j0.j0tran as j0tran,"
			+ "                 j0.j0tpdest as j0tpdest,"
			+ "                 j0.j0retorno as j0retorno,"
			+ "                 j0.j0prorroga as j0prorroga,"
			+ "                 j0.j0data as j0data,"
			+ "                 j0.j0hora as j0hora,"
			+ "                 j0.j0ensa as j0ensa,"
			+ "                 j0.j0motivo as j0motivo,"
			+ "                 j0.j0nota as j0nota,"
			+ "                 j0.j0doct as j0doct,"
			+ "                 j0.j0obs1 as j0obs1,"
			+ "                 j0.j0obs2 as j0obs2,"
			+ "                 j0.j0obs3 as j0obs3,"
			+ "                 j0.j0plac as j0plac,"
			+ "                 j0.j0port as j0port,"
			+ "                 j0.j0reto as j0reto,"
			+ "                 j0.j0stat as j0stat,"
			+ "                 j0.j0tpdc as j0tpdc,"
			+ "                 j0.j0ptfn as j0ptfn,"
			+ "        			bal.status_passe(j0.j0cod, j0.idfil) as dsStatus,"
			+ "                 f6.f6desc as dstransacao,"
			+ "                 DECODE(d4.d4apeli,NULL,c3.c3apeli,d4.d4apeli) as dsautor,"
			+ "                 DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome) as entidade, "
			+ "                 SUBSTR(DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome),1,30) as entidade_resumido,"
			+ "                 j0.j0portador as j0portador"
			+ "           FROM  bal.balj0_dbf j0, "
			+ "                 bal.balf6_dbf f6, "
			+ "                 spc.spcd4_dbf d4, "
			+ "                 spc.spcc3_dbf c3, "
			+ "                 ccp.ccpb2_dbf f, "
			+ "                 ccr.ccrb2_dbf c "
			+ "           WHERE j0.idfil = :idfil "
			+ "                 AND f6.idfil = j0.idfil "
			+ "                 AND j0.idfil = d4.idfil(+)"
			+ "                 AND j0.idfil = c3.idfil(+)"
			+ "                 AND j0.idfil = c.idfil(+)"
			+ "                 AND j0.idfil = f.idfil(+)"
			+ "                 AND j0.j0trsa = f6.f6cod "
			+ "                 AND j0.j0autor = d4.d4matr(+) "
			+ "                 AND j0.j0autor = c3.c3matr(+) "
			+ "                 AND j0.j0dest = c.b2cod(+) "
			+ "                 AND j0.j0dest = f.b2cod(+)"
			+ "                 AND j0.j0dtin >= (SYSDATE-10)"
			+ "                 AND j0.j0autor = :autor ", nativeQuery = true)
	Page<PasseGeral> passesDoUsuario(PageRequest pageRequest, @Param("idfil") String idfil, @Param("autor") String autor);

	@Transactional(readOnly=true)
	@Query(value="SELECT j0.j0dtin as j0dtin,"
			+ "           j0.idfil as idfil,"
			+ "           j0.j0cod as j0cod,"
			+ "           j0.j0geren as j0geren,"
			+ "           j0.j0autor as j0autor,"
			+ "           j0.j0cecu as j0cecu,"
			+ "           j0.j0dest as j0dest,"
			+ "           j0.j0trsa as j0trsa,"
			+ "           j0.j0tran as j0tran,"
			+ "           j0.j0tpdest as j0tpdest,"
			+ "           j0.j0retorno as j0retorno,"
			+ "           j0.j0prorroga as j0prorroga,"
			+ "           j0.j0data as j0data,"
			+ "           j0.j0hora as j0hora,"
			+ "           j0.j0ensa as j0ensa,"
			+ "           CAST(j0.j0motivo AS VARCHAR2(400)) as j0motivo,"
			+ "           j0.j0nota as j0nota,"
			+ "           j0.j0doct as j0doct,"
			+ "           j0.j0obs1 as j0obs1,"
			+ "           j0.j0obs2 as j0obs2,"
			+ "           j0.j0obs3 as j0obs3,"
			+ "           j0.j0plac as j0plac,"
			+ "           j0.j0port as j0port,"
			+ "           j0.j0reto as j0reto,"
			+ "           j0.j0stat as j0stat,"
			+ "           j0.j0tpdc as j0tpdc,"
			+ "           j0.j0ptfn as j0ptfn,"
			+ "        	  bal.status_passe(j0.j0cod, j0.idfil) as dsStatus,"
			+ "           f6.f6desc as dstransacao,"
			+ "           DECODE(d4.d4apeli,NULL,c3.c3apeli,d4.d4apeli) as dsautor,"
			+ "           DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome) as entidade, "
			+ "           SUBSTR(DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome),1,30) as entidade_resumido,"
			+ "           j0.j0portador as j0portador, "
			+ "           COUNT(*) as total "
			+ "     FROM  bal.balj0_dbf j0, "
			+ "           bal.balf6_dbf f6, "
			+ "           bal.balj1_dbf j1, "
			+ "           bal.balj2_dbf j2, "
			+ "           spc.spcd4_dbf d4, "
			+ "           spc.spcc3_dbf c3, "
			+ "           ccp.ccpb2_dbf f, "
			+ "           ccr.ccrb2_dbf c "
			+ "    WHERE  j0.idfil = :idfil "
			+ "           AND f6.idfil = j0.idfil "
			+ "           AND j0.idfil = d4.idfil(+)"
			+ "           AND j0.idfil = c3.idfil(+)"
			+ "           AND j0.idfil = c.idfil(+)"
			+ "           AND j0.idfil = f.idfil(+)"
			+ "           AND j0.idfil = j1.idfil(+)"
			+ "           AND j0.j0cod = j1.j1cod(+)"
			+ "           AND j1.idfil = j2.idfil(+)"
			+ "           AND j1.j1cod = j2.j2cod(+)"
			+ "           AND j1.j1item = j2.j2item(+)"
			+ "           AND j0.j0trsa = f6.f6cod "
			+ "           AND j0.j0autor = d4.d4matr(+) "
			+ "           AND j0.j0autor = c3.c3matr(+) "
			+ "           AND j0.j0dest = c.b2cod(+) "
			+ "           AND j0.j0dest = f.b2cod(+)"
			+ "           AND (:numeroPasse IS NULL OR j0.j0cod = :numeroPasse ) "
			+ "           AND (:cdAutor IS NULL OR j0.j0autor = :cdAutor ) "
			+ "           AND (:entradaSaida IS NULL OR j0.j0ensa = :entradaSaida ) "
			+ "           AND (:retorno IS NULL OR j0.j0reto = :retorno ) "
			+ "           AND (:status IS NULL OR TRIM(bal.status_passe(j0.j0cod, j0.idfil)) = TRIM(:status) ) "
			+ "           AND (:numDocumento IS NULL OR j0.j0doct = :numDocumento ) "
			+ "           AND (:notaFiscal IS NULL OR j0.j0nota = :notaFiscal ) "
			+ "           AND (:notaFiscalRetorno IS NULL OR j2.j2nota = :notaFiscalRetorno ) "
			+ "           AND (:notaFiscalVenda IS NULL OR j2.j2nvenda = :notaFiscalVenda ) "
			+ "           AND (:notaFiscalServico IS NULL OR j2.j2nserv = :notaFiscalServico ) "
			+ "           AND (:dataInclusaoInicial IS NULL OR TO_DATE(TO_CHAR(j0.j0dtin,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(:dataInclusaoInicial,'dd/mm/yyyy') AND TO_DATE(:dataInclusaoFinal,'dd/mm/yyyy') ) "
			+ "           AND (:dataPrevisaoRetornoInicial IS NULL OR TO_DATE(TO_CHAR(j0.j0retorno,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(:dataPrevisaoRetornoInicial,'dd/mm/yyyy') AND TO_DATE(:dataPrevisaoRetornoFinal,'dd/mm/yyyy') ) "
			+ "           AND (:dataRetornoInicial IS NULL OR TO_DATE(TO_CHAR(j2.j2data,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(:dataRetornoInicial,'dd/mm/yyyy') AND TO_DATE(:dataRetornoFinal,'dd/mm/yyyy') ) "
			+ "           AND (:dataVerificacaoInicial IS NULL OR TO_DATE(TO_CHAR(j0.j0data,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN TO_DATE(:dataVerificacaoInicial,'dd/mm/yyyy') AND TO_DATE(:dataVerificacaoFinal,'dd/mm/yyyy' ) ) "
			+ "           AND (:cdPorteiro IS NULL OR j0.j0port = :cdPorteiro ) "
			+ "           AND (:cdTransacao IS NULL OR j0.j0trsa = :cdTransacao ) "
			+ "           AND (:cdFornCli IS NULL OR j0.j0dest = :cdFornCli ) "
			+ "           AND (:tpFornCli IS NULL OR j0.j0tpdest = :tpFornCli ) "
			+ "           AND (:cdCCusto IS NULL OR j0.j0cecu = :cdCCusto ) "
			+ "           AND (:obsPasse IS NULL OR UPPER(TRIM(j0.j0obs1)||' '||TRIM(j0.j0obs2)||' '||TRIM(j0.j0obs3)) LIKE %:obsPasse% ) "
			+ "           AND (:obsItem IS NULL OR UPPER(TRIM(j1.j1obs1)||' '||TRIM(j1.j1obs2)||' '||TRIM(j1.j1obs3)) LIKE %:obsItem% ) "
			+ " GROUP BY j0.j0dtin,"
			+ "			 j0.idfil,"
			+ "			 j0.j0cod,"
			+ "			 j0.j0geren,"
			+ "			 j0.j0autor,"
			+ "			 j0.j0cecu,"
			+ "			 j0.j0dest,"
			+ "			 j0.j0trsa,"
			+ "			 j0.j0tran,"
			+ "			 j0.j0tpdest,"
			+ "			 j0.j0retorno,"
			+ "			 j0.j0prorroga,"
			+ "			 j0.j0data,"
			+ "			 j0.j0hora,"
			+ "			 j0.j0ensa,"
			+ "			 CAST(j0.j0motivo AS VARCHAR2(400)),"
			+ "			 j0.j0nota,"
			+ "			 j0.j0doct,"
			+ "			 j0.j0obs1,"
			+ "			 j0.j0obs2,"
			+ "			 j0.j0obs3,"
			+ "			 j0.j0plac,"
			+ "			 j0.j0port,"
			+ "			 j0.j0reto,"
			+ "			 j0.j0stat,"
			+ "			 j0.j0tpdc,"
			+ "			 j0.j0ptfn,"
			+ "			 bal.status_passe(j0.j0cod, j0.idfil),"
			+ "			 f6.f6desc,"
			+ "			 DECODE(d4.d4apeli,NULL,c3.c3apeli,d4.d4apeli),"
			+ "			 DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome),"
			+ "			 SUBSTR(DECODE(j0.j0tpdest,'C',c.b2nome,f.b2nome),1,30),"
			+ "			 j0.j0portador"
			+ " ", nativeQuery = true)
	List<PasseGeral> pesquisaPasses(
			@Param("idfil") String idfil, 
			@Param("numeroPasse") String numeroPasse,
			@Param("cdAutor") String cdAutor,
			@Param("entradaSaida") String entradaSaida,
			@Param("retorno") String retorno,
			@Param("status") String status,
			@Param("numDocumento") String numDocumento,
			@Param("notaFiscal") String notaFiscal,
			@Param("notaFiscalRetorno") String notaFiscalRetorno,
			@Param("notaFiscalVenda") String notaFiscalVenda,
			@Param("notaFiscalServico") String notaFiscalServico,
			@Param("dataInclusaoInicial") String dataInclusaoInicial,
			@Param("dataInclusaoFinal") String dataInclusaoFinal,
			@Param("dataPrevisaoRetornoInicial") String dataPrevisaoRetornoInicial,
			@Param("dataPrevisaoRetornoFinal") String dataPrevisaoRetornoFinal,
			@Param("dataRetornoInicial") String dataRetornoInicial,
			@Param("dataRetornoFinal") String dataRetornoFinal,
			@Param("dataVerificacaoInicial") String dataVerificacaoInicial,
			@Param("dataVerificacaoFinal") String dataVerificacaoFinal,
			@Param("cdPorteiro") String cdPorteiro,
			@Param("cdTransacao") String cdTransacao,
			@Param("cdFornCli") String cdFornCli,
			@Param("tpFornCli") String tpFornCli,
			@Param("cdCCusto") String cdCCusto,
			@Param("obsPasse") String obsPasse,
			@Param("obsItem") String obsItem
	);
	
}
