package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.PrecoProdutoDTO;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.repository.IProdutoRepository;
import br.com.mutualizo.desafio.service.IBuscarProdutoService;
import br.com.mutualizo.desafio.service.IEditarPrecoProdutoService;
import org.springframework.stereotype.Service;

@Service
public class EditarPrecoProdutoServiceImpl implements IEditarPrecoProdutoService {

    private final IProdutoRepository produtoRepository;
    private final IResponseMapper<PrecoProdutoDTO, Produto> responseMapper;
    private final IBuscarProdutoService buscarProdutoService;

    public EditarPrecoProdutoServiceImpl(
        IProdutoRepository produtoRepository,
        IResponseMapper<PrecoProdutoDTO, Produto> responseMapper,
        IBuscarProdutoService buscarProdutoService) {
        this.produtoRepository = produtoRepository;
        this.responseMapper = responseMapper;
        this.buscarProdutoService = buscarProdutoService;
    }

    @Override
    public PrecoProdutoDTO editar(Long idProduto, PrecoProdutoDTO request) {
        Produto produtoAtual = buscarProdutoService.buscar(idProduto);
        produtoAtual.setPreco(request.getPreco());
        produtoAtual = produtoRepository.save(produtoAtual);
        return responseMapper.toResponse(produtoAtual);
    }
}
