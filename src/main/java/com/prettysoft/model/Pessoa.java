package com.prettysoft.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoa", schema = "dbo")
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPessoa")
	private Integer idPessoa;

	@Column(length = 10, name = "cdChamada")
	private String cdChamada;

	@Column(length = 100, name = "nmPessoa")
	private String nmPessoa;

	@Column(length = 50, name = "nmCurto")
	private String nmCurto;

	@Column(length = 1, name = "tpPessoa")
	private String tpPessoa;

	@Column(length = 18, name = "telefone")
	private String telefone;

	@Column(length = 18, name = "celular")
	private String celular;

	@Column(length = 200, name = "email")
	private String email;

	@Column(length = 20, name = "cpfCnpj")
	private String cpfCnpj;

	@OneToMany(mappedBy = "id.pessoa", fetch = FetchType.EAGER)
	private Set<PessoaCategoria> categorias = new HashSet<PessoaCategoria>();

	public Pessoa() {
		super();
	}

	public Pessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public Pessoa(Integer idPessoa, String cdChamada, String nmPessoa, String nmCurto, String tpPessoa, String telefone,
			String celular, String email, String cpfCnpj) {
		super();
		this.idPessoa = idPessoa;
		this.cdChamada = cdChamada;
		this.nmPessoa = nmPessoa;
		this.nmCurto = nmCurto;
		this.tpPessoa = tpPessoa;
		this.telefone = telefone;
		this.celular = celular;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getCdChamada() {
		return cdChamada;
	}

	public void setCdChamada(String cdChamada) {
		this.cdChamada = cdChamada;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public String getNmCurto() {
		return nmCurto;
	}

	public void setNmCurto(String nmCurto) {
		this.nmCurto = nmCurto;
	}

	public String getTpPessoa() {
		return tpPessoa;
	}

	public void setTpPessoa(String tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public Set<PessoaCategoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(Set<PessoaCategoria> categorias) {
		this.categorias = categorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		return true;
	}

}

//@ManyToMany
//@JoinTable(
//		name = "Pessoa_Categoria", 
//		joinColumns = { @JoinColumn(name = "idPessoa", referencedColumnName="idPessoa") }, 
//		inverseJoinColumns = {@JoinColumn(name = "idCategoria",referencedColumnName="idCategoria") }
//		)
//private Set<Categoria> categorias;
