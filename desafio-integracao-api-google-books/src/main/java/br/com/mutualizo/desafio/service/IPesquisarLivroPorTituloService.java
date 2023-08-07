package br.com.mutualizo.desafio.service;

import br.com.mutualizo.desafio.dto.BookDTO;

import java.util.List;

public interface IPesquisarLivroPorTituloService {

    List<BookDTO> pesquisar(String titulo);

}
