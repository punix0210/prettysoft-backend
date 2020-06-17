package com.prettysoft.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.prettysoft.model.Embeddable.PessoaCategoriaKey;

@Entity
@Table(name = "PessoaCategoria", schema = "dbo")
public class PessoaCategoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PessoaCategoriaKey id = new PessoaCategoriaKey();

	@Column(length = 1, name = "stAtivo")
	private String stAtivo;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "dtCadastro")
	private Date dtCadastro;

	public PessoaCategoria() {
		super();
	}

	public PessoaCategoria(Pessoa pessoa, Categoria categoria, String stAtivo, Date dtCadastro) {
		super();
		this.id.setCategoria(categoria);
		this.id.setPessoa(pessoa);
		this.stAtivo = stAtivo;
		this.dtCadastro = dtCadastro;
	}

	public PessoaCategoriaKey getId() {
		return id;
	}

	public void setId(PessoaCategoriaKey id) {
		this.id = id;
	}
	
	@JsonIgnore
	public Pessoa getPessoa() {
		return id.getPessoa();
	}

	public void setPessoa(Pessoa pessoa) {
		this.id.setPessoa(pessoa);
	}	
	
	@JsonIgnore
	public Categoria getCategoria() {
		return id.getCategoria();
	}

	public void setCategoria(Categoria categoria) {
		this.id.setCategoria(categoria);
	}	

	public String getStAtivo() {
		return stAtivo;
	}

	public void setStAtivo(String stAtivo) {
		this.stAtivo = stAtivo;
	}

	public Date getDtCadastro() {
		return dtCadastro;
	}

	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		PessoaCategoria other = (PessoaCategoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
