package com.prettysoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AgendaItem")
public class AgendaItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAgendaItem")
	private Integer idAgendaItem;

	@Column(name = "quantidade")
	private Double quantidade;

	@ManyToOne()
	@JoinColumn(name = "idProduto", referencedColumnName = "idProduto")
	private Produto produto;

	@Column(name="vlUnitario")
	private Double vlUnitario;

	@Column(name="vlItem")
	private Double vlItem;

	@Column(name="alComissao")
	private Double alComissao;

	AgendaItem() {
		super();
	}

	public AgendaItem(Integer idAgendaItem, Double quantidade, Produto produto, Double vlUnitario, Double vlItem,
			Double alComissao) {
		super();
		this.idAgendaItem = idAgendaItem;
		this.quantidade = quantidade;
		this.produto = produto;
		this.vlUnitario = vlUnitario;
		this.vlItem = vlItem;
		this.alComissao = alComissao;
	}

	public Double getVlUnitario() {
		return vlUnitario;
	}

	public void setVlUnitario(Double vlUnitario) {
		this.vlUnitario = vlUnitario;
	}

	public Double getVlItem() {
		return vlItem;
	}

	public void setVlItem(Double vlItem) {
		this.vlItem = vlItem;
	}

	public Double getAlComissao() {
		return alComissao;
	}

	public void setAlComissao(Double alComissao) {
		this.alComissao = alComissao;
	}

	public Integer getIdAgendaItem() {
		return idAgendaItem;
	}

	public void setIdAgendaItem(Integer idAgendaItem) {
		this.idAgendaItem = idAgendaItem;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAgendaItem == null) ? 0 : idAgendaItem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendaItem other = (AgendaItem) obj;
		if (idAgendaItem == null) {
			if (other.idAgendaItem != null)
				return false;
		} else if (!idAgendaItem.equals(other.idAgendaItem))
			return false;
		return true;
	}

}
