package com.prettysoft.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Categoria", schema = "dbo")
@JsonIgnoreProperties("inspection")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCategoria")
	private Integer idCategoria;

	@Column(name = "cdChamada", length = 10)
	private String cdChamada;

	@Column(name = "nmCategoria", length = 100)
	private String nmCategoria;

	/*
	 * @OneToMany(mappedBy = "id.categoria")
	 * 
	 * @JsonBackReference private Set<PessoaCategoria> pessoas= new
	 * HashSet<PessoaCategoria>();
	 */

	public Categoria() {
		super();
	}

	public Categoria(Integer idCategoria, String cdChamada, String nmCategoria) {
		super();
		this.idCategoria = idCategoria;
		this.cdChamada = cdChamada;
		this.nmCategoria = nmCategoria;
	}

	/*
	 * public Set<PessoaCategoria> getPessoas() { return pessoas; }
	 * 
	 * public void setPessoas(Set<PessoaCategoria> pessoas) { this.pessoas =
	 * pessoas; }
	 */
	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getNmCategoria() {
		return nmCategoria;
	}

	public void setNmCategoria(String nmCategoria) {
		this.nmCategoria = nmCategoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCategoria == null) ? 0 : idCategoria.hashCode());
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
		Categoria other = (Categoria) obj;
		if (idCategoria == null) {
			if (other.idCategoria != null)
				return false;
		} else if (!idCategoria.equals(other.idCategoria))
			return false;
		return true;
	}

}
