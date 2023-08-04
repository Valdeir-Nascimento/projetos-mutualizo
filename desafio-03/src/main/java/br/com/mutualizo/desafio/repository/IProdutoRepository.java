package br.com.mutualizo.desafio.repository;

import br.com.mutualizo.desafio.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {
    
}
