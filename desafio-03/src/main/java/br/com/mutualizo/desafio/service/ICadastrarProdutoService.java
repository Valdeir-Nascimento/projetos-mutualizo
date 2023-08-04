package br.com.mutualizo.desafio.service;

import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;

public interface ICadastrarProdutoService {

    ProdutoResponse cadastrar(ProdutoRequest request);

}
