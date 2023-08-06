package br.com.mutualizo.desafio.repository;

import br.com.mutualizo.desafio.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
