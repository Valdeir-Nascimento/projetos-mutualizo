package br.com.mutualizo.desafio.service;

import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;

public interface IEditarProdutoService {

    ProdutoResponse editar(Long idProduto, ProdutoRequest request);

}
