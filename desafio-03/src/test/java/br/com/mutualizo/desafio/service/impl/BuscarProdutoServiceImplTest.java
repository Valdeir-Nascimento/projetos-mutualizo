package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.exception.ProdutoNaoEncontradoException;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.repository.IProdutoRepository;
import br.com.mutualizo.desafio.util.MockUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BuscarProdutoServiceImplTest {

    @InjectMocks
    private BuscarProdutoServiceImpl buscarProdutoService;
    @Mock
    private IProdutoRepository produtoRepository;
    private Produto produto;

    @BeforeEach
    void setup() {
        produto = MockUtil.getProduto();
    }

    @Test
    @DisplayName("Dado um produto valido quando buscar por id então deve retornar produto")
    void dadoUmProdutoValidoQuandoBuscarPorIdEntaoDeveRetornarProduto() {
        when(produtoRepository.findById(anyLong())).thenReturn(Optional.of(produto));
        Produto resposta = buscarProdutoService.buscar(produto.getId());
        assertNotNull(resposta);
    }

    @Test
    @DisplayName("Dado um produto quando buscar por id então deve lançar exception")
    void dadoUmProdutoQuandoBuscarPorIdEntaoDeveLancarException() {
        when(produtoRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(ProdutoNaoEncontradoException.class, ()-> buscarProdutoService.buscar(anyLong()));
    }

}