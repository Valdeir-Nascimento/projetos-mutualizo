package br.com.mutualizo.desafio.service;

import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;

public interface IEstoqueProdutoService {

    EstoqueProdutoResponse consultar(Long idProduto);

}
