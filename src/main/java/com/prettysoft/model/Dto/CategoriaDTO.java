package com.prettysoft.model.Dto;

public class CategoriaDTO {

	private Integer idCategoria;

	private String cdCategoria;

	private String nmCategoria;

	private String dtCadastro;

	private String stAtivo;

	public CategoriaDTO() {
	}


	public String getCdCategoria() {
		return cdCategoria;
	}

	public void setCdCategoria(String cdCategoria) {
		this.cdCategoria = cdCategoria;
	}

	public String getNmCategoria() {
		return nmCategoria;
	}

	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public String getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(String dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

}
