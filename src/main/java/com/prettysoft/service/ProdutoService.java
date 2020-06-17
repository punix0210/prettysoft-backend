package com.prettysoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prettysoft.model.Produto;
import com.prettysoft.model.Dto.ProdutoDTO;
import com.prettysoft.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository repository;

	public List<ProdutoDTO> findAll() {
		return this.objListToDtoList(this.repository.findAll());
	}

	public Produto create(Produto produto) {
		return this.repository.save(produto);
	}

	private List<ProdutoDTO> objListToDtoList(List<Produto> produtos) {

		List<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();

		for (Produto produto : produtos) {

			ProdutoDTO prod = new ProdutoDTO();

			prod.setAlRepasse(produto.getAlRepasse());
			prod.setCdChamada(produto.getCdChamada());
			prod.setIdProduto(produto.getIdProduto());
			prod.setNmProduto(produto.getNmProduto());
			prod.setNmProdutoCurto(produto.getNmProdutoCurto());
			prod.setTpServico(produto.getTpServico());
			prod.setVlCusto(produto.getVlCusto());
			prod.setVlPreco(produto.getVlPreco());

			produtosDTO.add(prod);

		}

		return produtosDTO;
	}

}
