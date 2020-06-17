package com.prettysoft.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prettysoft.model.Pessoa;
import com.prettysoft.model.PessoaCategoria;
import com.prettysoft.model.Dto.CategoriaDTO;
import com.prettysoft.model.Dto.PessoaDTO;
import com.prettysoft.repository.PessoaCategoriaRepository;
import com.prettysoft.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository repository;

	@Autowired
	PessoaCategoriaRepository repoCategoriaRepository;

	public List<PessoaDTO> findAllByCpfCnpj(String cpfCnpj) {

		List<Pessoa> pessoas = this.repository.findByCpfCnpj(cpfCnpj);

		return this.objectListToDtoList(pessoas);

	}

	public Pessoa findByIdPessoa(Integer idPessoa) {

		Pessoa pessoa = this.repository.findById(idPessoa).orElse(null);

		return pessoa;
	}

	public List<PessoaDTO> findAllByIdCategoria(Integer idCategoria) {

		System.out.println(idCategoria);

		List<Pessoa> pessoas = this.repository.findAllByCategorias(idCategoria);

		return objectListToDtoListFilterCategoria(pessoas, idCategoria);

	}

	public List<PessoaDTO> findAllByIdCategoriaAndNmPessoa(Integer idCategoria, String nmPessoa) {
		System.out.println(idCategoria);

		List<Pessoa> pessoas = this.repository.findAllByCategoriasAndNmPessoa(idCategoria, nmPessoa);

		return objectListToDtoListFilterCategoria(pessoas, idCategoria);
	}

	public Pessoa create(PessoaDTO pDTO) {

		Pessoa pessoa = this.repository.saveAndFlush(this.dtoToObject(pDTO));

		pDTO.setIdPessoa(pessoa.getIdPessoa());

		List<PessoaCategoria> categorias = this.dtoListToObjectList(pDTO);

		this.repoCategoriaRepository.saveAll(categorias);

		return pessoa;
	}

	public Pessoa update(PessoaDTO pDTO) {

		Pessoa pessoa = this.repository.saveAndFlush(this.dtoToObject(pDTO));

		pDTO.setIdPessoa(pessoa.getIdPessoa());

		List<PessoaCategoria> categorias = this.dtoListToObjectList(pDTO);

		this.repoCategoriaRepository.saveAll(categorias);

		return pessoa;
	}

	@SuppressWarnings("unused")
	private List<PessoaDTO> objectListToDtoListFilterPessoa(List<Pessoa> pessoas) {

		List<PessoaDTO> pessoasDTO = new ArrayList<PessoaDTO>();

		for (Pessoa pessoa : pessoas) {

			System.out.println(pessoa.getIdPessoa());

			PessoaDTO dto = new PessoaDTO();

			dto.setTpPessoa(pessoa.getTpPessoa());
			dto.setTelefone(pessoa.getTelefone());
			dto.setNmPessoa(pessoa.getNmPessoa());
			dto.setNmCurto(pessoa.getNmCurto());
			dto.setIdPessoa(pessoa.getIdPessoa());
			dto.setEmail(pessoa.getEmail());
			dto.setCpfCnpj(pessoa.getCpfCnpj());
			dto.setCelular(pessoa.getCelular());
			dto.setCdChamada(pessoa.getCdChamada());

			pessoasDTO.add(dto);
		}

		return pessoasDTO;
	}

	private List<PessoaDTO> objectListToDtoListFilterCategoria(List<Pessoa> pessoas, Integer idCategoria) {

		List<PessoaDTO> pessoasDTO = new ArrayList<PessoaDTO>();

		for (Pessoa pessoa : pessoas) {

			System.out.println(pessoa.getIdPessoa());

			PessoaDTO dto = new PessoaDTO();

			dto.setTpPessoa(pessoa.getTpPessoa());
			dto.setTelefone(pessoa.getTelefone());
			dto.setNmPessoa(pessoa.getNmPessoa());
			dto.setNmCurto(pessoa.getNmCurto());
			dto.setIdPessoa(pessoa.getIdPessoa());
			dto.setEmail(pessoa.getEmail());
			dto.setCpfCnpj(pessoa.getCpfCnpj());
			dto.setCelular(pessoa.getCelular());
			dto.setCdChamada(pessoa.getCdChamada());

			for (PessoaCategoria c1 : pessoa.getCategorias()) {

				CategoriaDTO c = new CategoriaDTO();

				if (c1.getCategoria().getIdCategoria() == idCategoria) {

					c.setCdCategoria(c1.getCategoria().getCdChamada());
					c.setIdCategoria(c1.getCategoria().getIdCategoria());
					c.setNmCategoria(c1.getCategoria().getNmCategoria());
					c.setDtCadastro(c1.getDtCadastro().toString());
					c.setStAtivo(c1.getStAtivo());
					// c.setIdPessoa(pessoa.getIdPessoa());

					dto.getCategorias().add(c);
				}

			}
			pessoasDTO.add(dto);
		}

		return pessoasDTO;
	}

	private List<PessoaDTO> objectListToDtoList(List<Pessoa> pessoas) {

		List<PessoaDTO> pessoasDTO = new ArrayList<PessoaDTO>();

		for (Pessoa pessoa : pessoas) {

			System.out.println(pessoa.getIdPessoa());

			PessoaDTO dto = new PessoaDTO();

			dto.setTpPessoa(pessoa.getTpPessoa());
			dto.setTelefone(pessoa.getTelefone());
			dto.setNmPessoa(pessoa.getNmPessoa());
			dto.setNmCurto(pessoa.getNmCurto());
			dto.setIdPessoa(pessoa.getIdPessoa());
			dto.setEmail(pessoa.getEmail());
			dto.setCpfCnpj(pessoa.getCpfCnpj());
			dto.setCelular(pessoa.getCelular());
			dto.setCdChamada(pessoa.getCdChamada());

			for (PessoaCategoria c1 : pessoa.getCategorias()) {

				CategoriaDTO c = new CategoriaDTO();

				c.setCdCategoria(c1.getCategoria().getCdChamada());
				c.setIdCategoria(c1.getCategoria().getIdCategoria());
				c.setNmCategoria(c1.getCategoria().getNmCategoria());
				c.setDtCadastro(c1.getDtCadastro().toString());
				c.setStAtivo(c1.getStAtivo());
				// c.setIdPessoa(pessoa.getIdPessoa());

				dto.getCategorias().add(c);
			}
			pessoasDTO.add(dto);
		}

		return pessoasDTO;
	}

	private Pessoa dtoToObject(PessoaDTO pDTO) {
		return new Pessoa(pDTO.getIdPessoa(), pDTO.getCdChamada(), pDTO.getNmPessoa(), pDTO.getNmCurto(),
				pDTO.getTpPessoa(), pDTO.getTelefone(), pDTO.getCelular(), pDTO.getEmail(), pDTO.getCpfCnpj());
	}

	
	@SuppressWarnings("unused")
	private PessoaDTO objectToDto(Pessoa pessoa) {

		PessoaDTO dto = new PessoaDTO();

		dto.setIdPessoa(pessoa.getIdPessoa());
		dto.setCdChamada(pessoa.getCdChamada());
		dto.setNmCurto(pessoa.getNmCurto());
		dto.setNmPessoa(pessoa.getNmPessoa());
		dto.setCpfCnpj(pessoa.getCpfCnpj());
		dto.setTelefone(pessoa.getTelefone());
		dto.setTpPessoa(pessoa.getTpPessoa());
		dto.setEmail(pessoa.getEmail());
		dto.setCelular(pessoa.getCelular());

		for (PessoaCategoria c1 : pessoa.getCategorias()) {

			CategoriaDTO c = new CategoriaDTO();

			c.setCdCategoria(c1.getCategoria().getCdChamada());
			c.setIdCategoria(c1.getCategoria().getIdCategoria());
			c.setNmCategoria(c1.getCategoria().getNmCategoria());
			c.setDtCadastro(c1.getDtCadastro().toString());
			c.setStAtivo(c1.getStAtivo());
			// c.setIdPessoa(pessoa.getIdPessoa());

			dto.getCategorias().add(c);
		}

		return dto;
	}

	private List<PessoaCategoria> dtoListToObjectList(PessoaDTO pessoaDTO) {

		List<PessoaCategoria> categorias = new ArrayList<PessoaCategoria>();

		for (CategoriaDTO c : pessoaDTO.getCategorias()) {

			PessoaCategoria categoria = new PessoaCategoria();

			categoria.getCategoria().setIdCategoria(c.getIdCategoria());
			categoria.getCategoria().setCdChamada(c.getCdCategoria());
			categoria.getCategoria().setNmCategoria(c.getNmCategoria());
			categoria.getPessoa().setIdPessoa(pessoaDTO.getIdPessoa());
			categoria.setDtCadastro(stringToDate(c.getDtCadastro()));
			categoria.setStAtivo(c.getStAtivo());

			categorias.add(categoria);
		}

		return categorias;
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
