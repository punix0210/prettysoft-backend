package com.prettysoft.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prettysoft.model.Agenda;
import com.prettysoft.model.AgendaItem;
import com.prettysoft.model.Pessoa;
import com.prettysoft.model.PessoaCategoria;
import com.prettysoft.model.Produto;
import com.prettysoft.model.Dto.AgendaDTO;
import com.prettysoft.model.Dto.AgendaItemDTO;
import com.prettysoft.model.Dto.CategoriaDTO;
import com.prettysoft.model.Dto.PessoaDTO;
import com.prettysoft.repository.AgendaRepository;

@Service
public class AgendaService {

	@Autowired
	AgendaRepository repository;

	public List<Agenda> findList() {
		return this.repository.findAll();
	}

	public List<AgendaDTO> findByData(String data) {

		List<AgendaDTO> dtos = objectListToDtoList(this.repository.findByData(stringToDate(data)));

		return dtos;
	}

	public List<AgendaDTO> findByDataAndNmPessoa(String data, String nmPessoa) {

		List<AgendaDTO> dtos = objectListToDtoList(this.repository.findByData(stringToDate(data)));

		return dtos;
	}

	public List<AgendaDTO> findAllByDataBetweenAndColaboradorContaining(String dtIni, String dtFim, Pessoa pessoa) {

		List<AgendaDTO> dtos = objectListToDtoList(
				this.repository.findAllByDataBetweenAndColaborador(stringToDate(dtIni), stringToDate(dtFim), pessoa));

		return dtos;
	}

	public List<AgendaDTO> findAll() {

		return objectListToDtoList(this.repository.findAll());

		// return new ArrayList<AgendaDTO>();
	}

	@Transactional
	public Agenda create(AgendaDTO agenda) {

		Agenda a = this.dtoToObject(agenda);

		System.out.println(a.getDescricao());
		System.out.println(a.getHorario());
		System.out.println(a.getStatus());
		System.out.println(a.getIdAgenda());
		System.out.println(a.getCliente().getIdPessoa());
		System.out.println(a.getObservacao());
		System.out.println(a.getTempo());
		System.out.println(a.getData());

		return this.repository.saveAndFlush(a);
	}

	@Transactional
	public void update(AgendaDTO agenda) {
		Agenda a = this.dtoToObject(agenda);
		this.repository.saveAndFlush(a);
	}

	private Date stringToDate(String data) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date date1 = null;

		try {
			date1 = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date1;
	}

	private Agenda dtoToObject(AgendaDTO dto) {

		Agenda agenda = new Agenda(dto.getIdAgenda(), dto.getDescricao(), this.stringToDate(dto.getData()),
				dto.getHorario(), dto.getStatus(), dto.getObservacao(), dto.getTempo(), dto.selectedColor(),
				dtoToObject(dto.getCliente()), dtoToObject(dto.getColaborador()));

		for (AgendaItemDTO item : dto.getItems()) {

			AgendaItem objItem = new AgendaItem(item.getIdAgendaItem(), item.getQuantidade(),
					new Produto(item.getProduto().getIdProduto(), item.getProduto().getCdChamada(),
							item.getProduto().getNmProduto(), item.getProduto().getNmProdutoCurto(), true,
							item.getProduto().getTpServico(), 0, item.getProduto().getVlPreco(),
							item.getProduto().getVlCusto(), item.getProduto().getAlRepasse()),
					item.getVlUnitario(), item.getVlItem(), item.getAlComissao());

			agenda.getItems().add(objItem);

		}

		return agenda;

	}

	private List<AgendaDTO> objectListToDtoList(List<Agenda> agendas) {

		List<AgendaDTO> dtos = new ArrayList<AgendaDTO>();

		for (Agenda agenda : agendas) {
			dtos.add(objectToDto(agenda));
		}

		return dtos;
	}

	private Pessoa dtoToObject(PessoaDTO pDTO) {
		return new Pessoa(pDTO.getIdPessoa(), pDTO.getCdChamada(), pDTO.getNmPessoa(), pDTO.getNmCurto(),
				pDTO.getTpPessoa(), pDTO.getTelefone(), pDTO.getCelular(), pDTO.getEmail(), pDTO.getCpfCnpj());
	}

	private AgendaDTO objectToDto(Agenda agenda) {

		PessoaDTO cDTO = new PessoaDTO();

		cDTO.setIdPessoa(agenda.getColaborador().getIdPessoa());
		cDTO.setCdChamada(agenda.getColaborador().getCdChamada());
		cDTO.setNmPessoa(agenda.getColaborador().getNmPessoa());
		cDTO.setNmCurto(agenda.getColaborador().getNmCurto());
		cDTO.setCpfCnpj(agenda.getColaborador().getCpfCnpj());
		cDTO.setEmail(agenda.getColaborador().getEmail());
		cDTO.setCelular(agenda.getColaborador().getCelular());
		cDTO.setTpPessoa(agenda.getColaborador().getTpPessoa());
		cDTO.setTelefone(agenda.getColaborador().getTelefone());

		for (PessoaCategoria c1 : agenda.getColaborador().getCategorias()) {

			CategoriaDTO c = new CategoriaDTO();

			c.setCdCategoria(c1.getCategoria().getCdChamada());
			c.setIdCategoria(c1.getCategoria().getIdCategoria());
			c.setNmCategoria(c1.getCategoria().getNmCategoria());
			c.setDtCadastro(c1.getDtCadastro().toString());
			c.setStAtivo(c1.getStAtivo());

			cDTO.getCategorias().add(c);

		}
		;

		PessoaDTO pDTO = new PessoaDTO();

		pDTO.setIdPessoa(agenda.getCliente().getIdPessoa());
		pDTO.setCdChamada(agenda.getCliente().getCdChamada());
		pDTO.setNmPessoa(agenda.getCliente().getNmPessoa());
		pDTO.setNmCurto(agenda.getCliente().getNmCurto());
		pDTO.setCpfCnpj(agenda.getCliente().getCpfCnpj());
		pDTO.setEmail(agenda.getCliente().getEmail());
		pDTO.setCelular(agenda.getCliente().getCelular());
		pDTO.setTpPessoa(agenda.getCliente().getTpPessoa());
		pDTO.setTelefone(agenda.getCliente().getTelefone());

		for (PessoaCategoria c1 : agenda.getCliente().getCategorias()) {

			CategoriaDTO c = new CategoriaDTO();

			c.setCdCategoria(c1.getCategoria().getCdChamada());
			c.setIdCategoria(c1.getCategoria().getIdCategoria());
			c.setNmCategoria(c1.getCategoria().getNmCategoria());
			c.setDtCadastro(c1.getDtCadastro().toString());
			c.setStAtivo(c1.getStAtivo());

			pDTO.getCategorias().add(c);

		}
		;

		AgendaDTO aDTO = new AgendaDTO();

		aDTO.setCliente(pDTO);
		aDTO.setData(agenda.getData().toString());
		aDTO.setDescricao(agenda.getDescricao());
		aDTO.setHorario(agenda.getHorario());
		aDTO.setIdAgenda(agenda.getIdAgenda());
		aDTO.setObservacao(agenda.getObservacao());
		aDTO.setStatus(agenda.getStatus());
		aDTO.setTempo(agenda.getTempo());
		aDTO.setColor(aDTO.selectedColor());
		aDTO.setColaborador(cDTO);

		for (AgendaItem itens : agenda.getItems()) {

			AgendaItemDTO dto = new AgendaItemDTO();

			dto.setIdAgendaItem(itens.getIdAgendaItem());
			dto.getProduto().setAlRepasse(itens.getProduto().getAlRepasse());
			dto.getProduto().setCdChamada(itens.getProduto().getCdChamada());
			dto.getProduto().setIdProduto(itens.getProduto().getIdProduto());
			dto.getProduto().setNmProduto(itens.getProduto().getNmProduto());
			dto.getProduto().setNmProdutoCurto(itens.getProduto().getNmProdutoCurto());
			dto.getProduto().setTpServico(itens.getProduto().getTpServico());
			dto.getProduto().setVlCusto(itens.getProduto().getVlCusto());
			dto.getProduto().setVlPreco(itens.getProduto().getVlPreco());
			dto.setQuantidade(itens.getQuantidade());
			dto.setAlComissao(itens.getAlComissao());
			dto.setVlUnitario(itens.getVlUnitario());
			dto.setVlItem(itens.getVlItem());

			aDTO.getItems().add(dto);
		}

		return aDTO;
	}

}

/*
 * public List<PessoaDTO> findAllByIdCategoria(Integer idCategoria) { return
 * this.repository.findAllByCategorias(idCategoria); }
 * 
 * public Pessoa create(PessoaDTO pDTO) {
 * 
 * Pessoa pessoa = this.repository.saveAndFlush(this.dtoToObject(pDTO));
 * 
 * PessoaCategoria categoria = new PessoaCategoria();
 * 
 * categoria.getCategoria().setIdCategoria(pDTO.getIdCategoria());
 * categoria.getPessoa().setIdPessoa(pessoa.getIdPessoa());
 * categoria.setStAtivo(pDTO.getStAtivo());
 * categoria.setDtCadastro(stringToDate(pDTO.getDtCadastro()));
 * 
 * pessoa.getCategorias().add(categoria);
 * 
 * this.repoCategoriaRepository.saveAll(pessoa.getCategorias());
 * 
 * return pessoa; }
 * 
 * 
 * 
 * 
 * 
 * /* pessoa.getCategorias().forEach((value) -> { value.setPessoa(p); });
 */
