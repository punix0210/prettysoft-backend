package com.prettysoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.prettysoft.model.PessoaCategoria;
import com.prettysoft.model.Embeddable.PessoaCategoriaKey;

@Repository
public interface PessoaCategoriaRepository  extends JpaRepository<PessoaCategoria, PessoaCategoriaKey> {

//	List<Pessoa> findAllByCategorias();

}
