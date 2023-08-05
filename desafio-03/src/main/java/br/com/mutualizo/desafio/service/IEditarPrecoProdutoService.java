package br.com.mutualizo.desafio.service;

import br.com.mutualizo.desafio.dto.request.PrecoProdutoRequest;
import br.com.mutualizo.desafio.dto.response.PrecoProdutoResponse;

public interface IEditarPrecoProdutoService {

    PrecoProdutoResponse editar(Long idProduto, PrecoProdutoRequest request);

}
