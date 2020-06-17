package com.prettysoft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.prettysoft.model.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

	@Query(value = "select P.* from dbo.Pessoa P Join dbo.PessoaCategoria PC On (P.idPessoa = PC.idPessoa) where PC.idCategoria=?1", nativeQuery = true)
	public List<Pessoa> findAllByCategorias(Integer idCategoria);

	@Query(value = "select distinct P.* from dbo.Pessoa P where P.cpfCnpj like %?1%", nativeQuery = true)
	List<Pessoa> findByCpfCnpj(String cpfCnpj);

	@Query(value = "select P.* from dbo.Pessoa P Join dbo.PessoaCategoria PC On (P.idPessoa = PC.idPessoa)"
			+ " where (PC.idCategoria=?1) and (P.nmPessoa like %?2%)", nativeQuery = true)
	public List<Pessoa> findAllByCategoriasAndNmPessoa(Integer idCategoria, String nmPessoa);
	
	// List<Pessoa> findByCategorias(List<PessoaCategoria> categorias);
}
