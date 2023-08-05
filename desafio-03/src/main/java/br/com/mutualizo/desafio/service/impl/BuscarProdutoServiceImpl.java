package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.exception.ProdutoNaoEncontradoException;
import br.com.mutualizo.desafio.service.IBuscarProdutoService;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarProdutoServiceImpl implements IBuscarProdutoService {

    private final IProdutoRepository produtoRepository;

    public BuscarProdutoServiceImpl(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto buscar(Long idProduto) {
        return produtoRepository.findById(idProduto)
                .orElseThrow(() -> new ProdutoNaoEncontradoException(idProduto));
    }
}
