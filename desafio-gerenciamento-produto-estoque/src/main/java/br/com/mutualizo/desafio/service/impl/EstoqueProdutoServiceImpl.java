package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;
import br.com.mutualizo.desafio.service.IBuscarProdutoService;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.service.IEstoqueProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstoqueProdutoServiceImpl implements IEstoqueProdutoService {

    private final IBuscarProdutoService buscarProdutoService;
    private final IResponseMapper<EstoqueProdutoResponse, Produto> responseMapper;

    @Override
    public EstoqueProdutoResponse consultar(Long idProduto) {
        Produto produto = buscarProdutoService.buscar(idProduto);
        return responseMapper.toResponse(produto);
    }

}
