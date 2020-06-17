package com.prettysoft.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prettysoft.model.Pessoa;
import com.prettysoft.model.Dto.PessoaDTO;
import com.prettysoft.service.PessoaService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "pessoas")
public class PessoaResource {

	@Autowired
	PessoaService service;

	@RequestMapping(value = "/categoria/{idCategoria}", method = RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findAllByIdCategoria(@PathVariable("idCategoria") Integer idCategoria) {
		return ResponseEntity.ok().body(this.service.findAllByIdCategoria(idCategoria));
	}
	
	@RequestMapping(value = "/categoria/{idCategoria}/pessoa/{nmPessoa}", method = RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findAllByIdCategoriaAndNmPessoa(
			@PathVariable("idCategoria") Integer idCategoria,
			@PathVariable("nmPessoa") String nmPessoa ) {
		return ResponseEntity.ok().body(this.service.findAllByIdCategoriaAndNmPessoa(idCategoria,nmPessoa));
	}	

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<PessoaDTO>> findByCpfCnpj(
			@RequestParam(value = "cpfCnpj", required = true, defaultValue = "") String cpfCnpj) {
		return ResponseEntity.ok().body(this.service.findAllByCpfCnpj(cpfCnpj));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestBody PessoaDTO pessoa) {
		Pessoa obj = service.create(pessoa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPessoa}").buildAndExpand(obj.getIdPessoa())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PessoaDTO pessoa) {
		service.update(pessoa);
		return ResponseEntity.noContent().build();
	}

}
