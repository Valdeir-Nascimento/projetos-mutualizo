package br.com.mutualizo.desafio.service;

import br.com.mutualizo.desafio.dto.PrecoProdutoDTO;
import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;

public interface IEditarPrecoProdutoService {

    PrecoProdutoDTO editar(Long idProduto, PrecoProdutoDTO request);

}
