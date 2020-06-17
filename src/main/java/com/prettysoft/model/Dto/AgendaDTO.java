package com.prettysoft.model.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AgendaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idAgenda;

	private String descricao;

	private String data;

	private String horario;

	private String status;

	private String observacao;

	private PessoaDTO cliente = new PessoaDTO();

	private Integer tempo;

	private String color;

	private PessoaDTO colaborador = new PessoaDTO();

	private List<AgendaItemDTO> items = new ArrayList<AgendaItemDTO>();

	public AgendaDTO() {
	}

	public List<AgendaItemDTO> getItems() {
		return items;
	}

	public void setItems(List<AgendaItemDTO> items) {
		this.items = items;
	}

	public PessoaDTO getColaborador() {
		return colaborador;
	}

	public void setColaborador(PessoaDTO colaborador) {
		this.colaborador = colaborador;
	}

	public String selectedColor() {

		// String color = "merda";

		if (this.status.trim().equals("A")) {
			return "#FF9900";
		} else if (this.status.trim().equals("L")) {
			return "#339933";
		} else if (this.status.trim().equals("T")) {
			return "#0066CC";
		} else if (this.status.trim().equals("C")) {
			return "#CC0000";
		} else {
			return "";
		}

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
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

	public PessoaDTO getCliente() {
		return cliente;
	}

	public void setCliente(PessoaDTO cliente) {
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
		AgendaDTO other = (AgendaDTO) obj;
		if (idAgenda == null) {
			if (other.idAgenda != null)
				return false;
		} else if (!idAgenda.equals(other.idAgenda))
			return false;
		return true;
	}

}
