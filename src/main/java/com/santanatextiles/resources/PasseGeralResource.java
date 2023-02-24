package com.santanatextiles.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santanatextiles.PassegeralApplication;
import com.santanatextiles.domain.PasseGeral;
import com.santanatextiles.dto.PasseGeralDTO;
import com.santanatextiles.services.PasseGeralService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value="/passegeral")
public class PasseGeralResource {

	@Autowired
	private PasseGeralService service; 
	
	@RequestMapping(value="/{numeroPasse}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable String numeroPasse) {
		
		PasseGeral obj = service.buscar(PassegeralApplication._EMPRESA , numeroPasse);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> insert(@Valid @RequestBody PasseGeralDTO objDTO) {
		PasseGeral obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		return ResponseEntity.status(HttpStatus.OK).body("Código do Passe: " + obj.getNumeroPasse());
	}

	@RequestMapping(value="{numeroPasse}",method=RequestMethod.PUT)
	public ResponseEntity<String> update(@Valid @RequestBody PasseGeralDTO objDTO, @PathVariable String numeroPasse) {
		PasseGeral obj = service.fromDTO(objDTO);
		obj.setNumeroPasse(numeroPasse);
		obj = service.update(obj);
		return ResponseEntity.status(HttpStatus.OK).body("Alteração Efetuada Passe: " + obj.getNumeroPasse());
	}

	/*
	localhost:8082/passegeral/{numeroPasse}/aprovar/{gerente}
	*/
	@RequestMapping(value="{numeroPasse}/aprovar/{gerente}",method=RequestMethod.GET)
	public ResponseEntity<String> aprovarPasseGeral(@PathVariable String numeroPasse, @PathVariable String gerente) {
		PasseGeral obj = service.aprovaPasseGeral(numeroPasse , gerente);
		return ResponseEntity.status(HttpStatus.OK).body("Passe Aprovado: " + obj.getNumeroPasse());
	}

	/*
	localhost:8082/passegeral/{numeroPasse}/desaprovar
	*/
	@RequestMapping(value="{numeroPasse}/desaprovar",method=RequestMethod.GET)
	public ResponseEntity<String> aprovarPasseGeral(@PathVariable String numeroPasse) {
		PasseGeral obj = service.desaprovaPasseGeral(numeroPasse);
		return ResponseEntity.status(HttpStatus.OK).body("Passe Desaprovado: " + obj.getNumeroPasse());
	}

	/*
	localhost:8082/passegeral/{numeroPasse}/verificar{
	{
	    "data" : "23/02/2023",
	    "hora" : "09:37",
	    "porteiro" : "30087",
	    "transportadora" : "0476",
	    "tipotransporte" : "R",
	    "placa" : "HWI-1F34"
	}
	*/
	@RequestMapping(value="{numeroPasse}/verificar",method=RequestMethod.POST)
	public ResponseEntity<String> verificarPasseGeral(@PathVariable String numeroPasse,
			@RequestBody Map<String , Object> dados) throws Exception {
		Date dia = new SimpleDateFormat("dd/MM/yyyy").parse(dados.get("data").toString());
		PasseGeral obj = service.verificaPasseGeral(
				numeroPasse,
				dia,
				dados.get("hora").toString(),
				dados.get("porteiro").toString(),
				dados.get("transportadora").toString(),
				dados.get("tipotransporte").toString(),
				dados.get("placa").toString()
				);
		return ResponseEntity.status(HttpStatus.OK).body("Passe Verificado: " + obj.getNumeroPasse());
	}

	/*
	localhost:8082/passegeral/{numeroPasse}/prorrogar
	{
	    "data" : "25/02/2023",
	    "motivo" : "TESTE DE MOTIVO"
	}
	*/
	@RequestMapping(value="{numeroPasse}/prorrogar",method=RequestMethod.POST)
	public ResponseEntity<String> prorrogaPasseGeral(@PathVariable String numeroPasse,
			@RequestBody Map<String , Object> dados) throws Exception {
		Date dia = new SimpleDateFormat("dd/MM/yyyy").parse(dados.get("data").toString());
		PasseGeral obj = service.prorrogaPasseGeral(
				numeroPasse,
				dia,
				dados.get("motivo").toString()
				);
		return ResponseEntity.status(HttpStatus.OK).body("Passe Prorrogado: " + obj.getNumeroPasse());
	}

	/*
	localhost:8082/passegeral/{numeroPasse}/lancarnota
	{
	    "nota" : "25/02/2023"
	}
	*/
	@RequestMapping(value="{numeroPasse}/lancarnota",method=RequestMethod.POST)
	public ResponseEntity<String> lancaNotaPasseGeral(@PathVariable String numeroPasse,
			@RequestBody Map<String , Object> dados) throws Exception {
		PasseGeral obj = service.lancaNotaPasseGeral(
				numeroPasse,
				dados.get("nota").toString()
				);
		return ResponseEntity.status(HttpStatus.OK).body("Nota Lançada Passe: " + obj.getNumeroPasse());
	}
	
	/*
	localhost:8082/passegeral/{numeroPasse}/desverificar
	*/
	@RequestMapping(value="{numeroPasse}/desverificar",method=RequestMethod.GET)
	public ResponseEntity<String> desverificarPasseGeral(@PathVariable String numeroPasse) throws Exception {
		PasseGeral obj = service.desverificaPasseGeral(numeroPasse);
		return ResponseEntity.status(HttpStatus.OK).body("Passe Desverificado: " + obj.getNumeroPasse());
	}
	
	@RequestMapping(value="{numeroPasse}",method=RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable String numeroPasse) {
		service.delete(numeroPasse);
		return ResponseEntity.status(HttpStatus.OK).body("Deleção Efetuada Passe: " + numeroPasse);
	}
	
	/*
	localhost:8082/passegeral?linesPerPage=3&page=1&direction=ASC&orderBy=fornecedor.descricao
	*/
	@RequestMapping(method=RequestMethod.GET)
	public  ResponseEntity<Page<PasseGeral>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="dataInclusao") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<PasseGeral> lista = service.listagemGeral(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value="/portador/{portador}",method=RequestMethod.GET)
	public  ResponseEntity<List<PasseGeral>> procuraPorPortador(@PathVariable String portador) {
		List<PasseGeral> lista = service.procuraPorPortador(PassegeralApplication._EMPRESA, portador);
		return ResponseEntity.ok().body(lista);
	}
	
	/*
	localhost:8082/passegeral/averificar/?linesPerPage=3&page=1&direction=ASC&orderBy=dataInclusao
	*/
	@RequestMapping(value="/averificar",method=RequestMethod.GET)
	public  ResponseEntity<Page<PasseGeral>> passesNaoVerificados(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="j0dtin") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<PasseGeral> lista = service.passesNaoVerificados(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/passegeral/naoaprovados/{gerente}?linesPerPage=3&page=1&direction=ASC&orderBy=dataInclusao
	*/
	@RequestMapping(value="/naoaprovados/{gerente}",method=RequestMethod.GET)
	public  ResponseEntity<Page<PasseGeral>> passesNaoAprovados(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="j0dtin") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable String gerente) {
		Page<PasseGeral> lista = service.passesNaoAprovados(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA, gerente);
		return ResponseEntity.ok().body(lista);
	}

	/*
	localhost:8082/passegeral/dousuario/{autor}?linesPerPage=3&page=1&direction=ASC&orderBy=dataInclusao
	*/
	@RequestMapping(value="/dousuario/{autor}",method=RequestMethod.GET)
	public  ResponseEntity<Page<PasseGeral>> passesDoUsuario(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="j0dtin") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction,
			@PathVariable String autor) {
		Page<PasseGeral> lista = service.passesDoUsuario(page, linesPerPage, orderBy, direction, PassegeralApplication._EMPRESA, autor);
		return ResponseEntity.ok().body(lista);
	}
	
}
