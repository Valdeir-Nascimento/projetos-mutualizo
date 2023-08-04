package br.com.mutualizo.desafio.service;

import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;

public interface IConsultarEstoqueProdutoService {

    EstoqueProdutoResponse consultar(Long idProduto);

}
