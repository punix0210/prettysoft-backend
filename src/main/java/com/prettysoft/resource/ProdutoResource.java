package com.prettysoft.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prettysoft.model.Produto;
import com.prettysoft.model.Dto.PessoaDTO;
import com.prettysoft.model.Dto.ProdutoDTO;
import com.prettysoft.service.ProdutoService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "produtos")
public class ProdutoResource {

	@Autowired
	ProdutoService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		return ResponseEntity.ok().body(this.service.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestBody Produto produto) {
		Produto obj =  this.service.create(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idProduto}")
				.buildAndExpand(obj.getIdProduto()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PessoaDTO pessoa) {
		return ResponseEntity.noContent().build();
	}

}
