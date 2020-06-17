package com.prettysoft.model.Dto;

public class ProdutoDTO {

	private Integer idProduto;

	private String cdChamada;

	private String nmProduto;

	private String nmProdutoCurto;

	private String tpServico;

	private Double vlPreco;

	private Double vlCusto;

	private Double alRepasse;

	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Integer idProduto, String cdChamada, String nmProduto, String nmProdutoCurto, String tpServico,
			Double vlPreco, Double vlCusto, Double alRepasse) {
		super();
		this.idProduto = idProduto;
		this.cdChamada = cdChamada;
		this.nmProduto = nmProduto;
		this.nmProdutoCurto = nmProdutoCurto;
		this.tpServico = tpServico;
		this.vlPreco = vlPreco;
		this.vlCusto = vlCusto;
		this.alRepasse = alRepasse;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getNmProduto() {
		return nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public String getNmProdutoCurto() {
		return nmProdutoCurto;
	}

	public void setNmProdutoCurto(String nmProdutoCurto) {
		this.nmProdutoCurto = nmProdutoCurto;
	}

	public String getTpServico() {
		return tpServico;
	}

	public void setTpServico(String tpServico) {
		this.tpServico = tpServico;
	}

	public Double getVlPreco() {
		return vlPreco;
	}

	public void setVlPreco(Double vlPreco) {
		this.vlPreco = vlPreco;
	}

	public Double getVlCusto() {
		return vlCusto;
	}

	public void setVlCusto(Double vlCusto) {
		this.vlCusto = vlCusto;
	}

	public Double getAlRepasse() {
		return alRepasse;
	}

	public void setAlRepasse(Double alRepasse) {
		this.alRepasse = alRepasse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
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
		ProdutoDTO other = (ProdutoDTO) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}

}
