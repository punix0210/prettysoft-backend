package com.prettysoft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Produto")
@Entity
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProduto")
	private Integer idProduto;

	@Column(name = "cdChamada")
	private String cdChamada;

	@Column(name = "nmProduto")
	private String nmProduto;

	@Column(name = "nmProdutoCurto")
	private String nmProdutoCurto;

	@Column(name = "stAtivo")
	private Boolean stAtivo;

	@Column(name = "tpServico")
	private String tpServico;

	@Column(name = "tempo")
	private Integer tempo;

	@Column(name = "vlPreco")
	private Double vlPreco;

	@Column(name = "vlCusto")
	private Double vlCusto;

	@Column(name = "alRepasse")
	private Double alRepasse;

	public Produto() {
		super();
	}

	public Produto(Integer idProduto, String cdChamada, String nmProduto, String nmProdutoCurto, Boolean stAtivo,
			String tpServico, Integer tempo, Double vlPreco, Double vlCusto, Double alRepasse) {
		super();
		this.idProduto = idProduto;
		this.cdChamada = cdChamada;
		this.nmProduto = nmProduto;
		this.nmProdutoCurto = nmProdutoCurto;
		this.stAtivo = stAtivo;
		this.tpServico = tpServico;
		this.tempo = tempo;
		this.vlPreco = vlPreco;
		this.vlCusto = vlCusto;
		this.alRepasse = alRepasse;
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

	public Boolean getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(Boolean stAtivo) {
		this.stAtivo = stAtivo;
	}

	public String getTpServico() {
		return tpServico;
	}

	public void setTpServico(String tpServico) {
		this.tpServico = tpServico;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
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
		Produto other = (Produto) obj;
		if (idProduto == null) {
			if (other.idProduto != null)
				return false;
		} else if (!idProduto.equals(other.idProduto))
			return false;
		return true;
	}

}
