package com.prettysoft.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Agenda", schema = "dbo")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAgenda;

	@Column(name = "descricao")
	private String descricao;

	@Temporal(value = TemporalType.DATE)
	@Column(name = "data")
	private Date data;

	@Column(name = "horario")
	private String horario;

	@Column(name = "status")
	private String status;

	@Column(name = "observacao")
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "idPessoa", referencedColumnName = "idPessoa")
	private Pessoa cliente = new Pessoa();

	@ManyToOne
	@JoinColumn(name = "idColaborador", referencedColumnName = "idPessoa")
	private Pessoa colaborador = new Pessoa();

	@Column(name = "tempo")
	private Integer tempo;

	@Column(name = "color")
	private String color;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "idAgenda")
	private List<AgendaItem> items = new ArrayList<AgendaItem>();

	public Agenda() {
		super();
	}

	public Agenda(Integer idAgenda, String descricao, Date data, String horario, String status, String observacao,
			Integer tempo, String color, Pessoa pessoa, Pessoa colaborador) {
		super();
		this.idAgenda = idAgenda;
		this.descricao = descricao;
		this.data = data;
		this.horario = horario;
		this.status = status;
		this.observacao = observacao;
		this.tempo = tempo;
		this.cliente = pessoa;
		this.color = color;
		this.colaborador = colaborador;
	}

	public List<AgendaItem> getItems() {
		return items;
	}

	public void setItems(List<AgendaItem> items) {
		this.items = items;
	}

	public Pessoa getColaborador() {
		return colaborador;
	}

	public void setColaborador(Pessoa colaborador) {
		this.colaborador = colaborador;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public Integer getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAgenda == null) ? 0 : idAgenda.hashCode());
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
		Agenda other = (Agenda) obj;
		if (idAgenda == null) {
			if (other.idAgenda != null)
				return false;
		} else if (!idAgenda.equals(other.idAgenda))
			return false;
		return true;
	}

}
