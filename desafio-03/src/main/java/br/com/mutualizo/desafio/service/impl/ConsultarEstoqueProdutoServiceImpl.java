package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;
import br.com.mutualizo.desafio.exception.ProdutoNaoEncontradoException;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.repository.IProdutoRepository;
import br.com.mutualizo.desafio.service.IConsultarEstoqueProdutoService;
import org.springframework.stereotype.Service;

@Service
public class ConsultarEstoqueProdutoServiceImpl implements IConsultarEstoqueProdutoService {

    private final IProdutoRepository produtoRepository;
    private final IResponseMapper<EstoqueProdutoResponse, Produto> responseMapper;

    public ConsultarEstoqueProdutoServiceImpl(IProdutoRepository produtoRepository, IResponseMapper<EstoqueProdutoResponse, Produto> responseMapper) {
        this.produtoRepository = produtoRepository;
        this.responseMapper = responseMapper;
    }

    @Override
    public EstoqueProdutoResponse consultar(Long idProduto) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(idProduto));
        return responseMapper.toResponse(produto);
    }

}
