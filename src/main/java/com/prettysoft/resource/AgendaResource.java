package com.prettysoft.resource;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prettysoft.model.Agenda;
import com.prettysoft.model.Pessoa;
import com.prettysoft.model.Dto.AgendaDTO;

import com.prettysoft.service.AgendaService;
import com.prettysoft.service.PessoaService;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "agendamentos")
public class AgendaResource {

	@Autowired
	AgendaService service;

	@Autowired
	PessoaService pessoaService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseEntity<List<Agenda>> findList() {

		return ResponseEntity.status(HttpStatus.OK).body(this.service.findList());
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findAll() {

		List<AgendaDTO> agendas = this.service.findAll();

		if (agendas.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(agendas);
		}

		return ResponseEntity.status(HttpStatus.OK).body(agendas);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> create(@Valid @RequestBody AgendaDTO agenda) {
		Agenda obj = service.create(agenda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idPessoa}").buildAndExpand(obj.getIdAgenda())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AgendaDTO agenda) {
		service.update(agenda);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/agenda", method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findByData(
			@RequestParam(value = "data", defaultValue = "", required = true) String data) {
		return ResponseEntity.ok().body(this.service.findByData(data));
	}

	@RequestMapping(value = "/pessoas", method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findByDataAndNmPessoa(
			@RequestParam(value = "data", defaultValue = "", required = true) String data,
			@RequestParam(value = "nome", defaultValue = "", required = true) String nome) {
		return ResponseEntity.ok().body(this.service.findByDataAndNmPessoa(data, nome));
	}

	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
	public ResponseEntity<List<AgendaDTO>> findAllByDataBetweenAndNmPessoa(
			@RequestParam(value = "dtIni", defaultValue = "", required = true) String dtIni,
			@RequestParam(value = "dtFim", defaultValue = "", required = true) String dtFim,
			@RequestParam(value = "id", defaultValue = "0", required = false) Integer idPessoa) {

		if (idPessoa == 0) {
			return ResponseEntity.ok().body(new ArrayList<AgendaDTO>());
		} else {
			Pessoa pessoa = this.pessoaService.findByIdPessoa(idPessoa);
			return ResponseEntity.ok()
					.body(this.service.findAllByDataBetweenAndColaboradorContaining(dtIni, dtFim, pessoa));
		}

	}

}

// return ResponseEntity.ok().header("Custom-Header","Agendas").body(list);
