package com.prettysoft.model.Dto;

public class AgendaItemDTO {

	private Integer idAgendaItem;

	private Double quantidade;

	private ProdutoDTO produto = new ProdutoDTO();

	private Double vlUnitario;

	private Double vlItem;

	private Double alComissao;

	public AgendaItemDTO(Integer idAgendaItem, Double quantidade, ProdutoDTO produto, Double vlUnitario, Double vlItem,
			Double alComissao) {
		super();
		this.idAgendaItem = idAgendaItem;
		this.quantidade = quantidade;
		this.produto = produto;
		this.vlUnitario = vlUnitario;
		this.vlItem = vlItem;
		this.alComissao = alComissao;
	}

	public AgendaItemDTO() {
		super();
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

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
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
		AgendaItemDTO other = (AgendaItemDTO) obj;
		if (idAgendaItem == null) {
			if (other.idAgendaItem != null)
				return false;
		} else if (!idAgendaItem.equals(other.idAgendaItem))
			return false;
		return true;
	}

}
