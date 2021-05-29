package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long>{
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); //findAllByTitulo>>"Buscar todos pelo o Titulo" que é o nome no atributo da minha entidade //CONTAINING>>"Tudo que conter na variavel TITULO ele vai trazer //IGNORECASE>>Não levar em consideração o maiusculo e minusculo
}
