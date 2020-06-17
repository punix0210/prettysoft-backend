package com.prettysoft.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prettysoft.model.Agenda;
import com.prettysoft.model.Pessoa;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Integer> {

	public List<Agenda> findByData(Date data);

	public List<Agenda> findAllByDataBetween(Date DtIni, Date DtFim);
	
	public List<Agenda> findAllByDataBetweenAndColaborador(Date DtIni, Date DtFim, Pessoa pessoa);
	

}
