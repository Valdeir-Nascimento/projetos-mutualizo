package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import br.com.mutualizo.desafio.mapper.ICopyToProperties;
import br.com.mutualizo.desafio.mapper.IRequestMapper;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.repository.IProdutoRepository;
import br.com.mutualizo.desafio.service.IBuscarProdutoService;
import br.com.mutualizo.desafio.service.IEditarProdutoService;
import org.springframework.stereotype.Service;

@Service
public class EditarProdutoServiceImpl implements IEditarProdutoService {

    private final IProdutoRepository produtoRepository;
    private final IResponseMapper<ProdutoResponse, Produto> responseMapper;
    private final ICopyToProperties<ProdutoRequest, Produto> copyToProperties;
    private final IBuscarProdutoService buscarProdutoService;

    public EditarProdutoServiceImpl(
        IProdutoRepository produtoRepository,
        IResponseMapper<ProdutoResponse, Produto> responseMapper,
        ICopyToProperties<ProdutoRequest, Produto> copyToProperties, IBuscarProdutoService buscarProdutoService) {
        this.produtoRepository = produtoRepository;
        this.responseMapper = responseMapper;
        this.copyToProperties = copyToProperties;
        this.buscarProdutoService = buscarProdutoService;
    }

    @Override
    public ProdutoResponse editar(Long idProduto, ProdutoRequest request) {
        Produto produtoAtual = buscarProdutoService.buscar(idProduto);
        copyToProperties.copy(request, produtoAtual);
        produtoAtual = produtoRepository.save(produtoAtual);
        return responseMapper.toResponse(produtoAtual);
    }
}
