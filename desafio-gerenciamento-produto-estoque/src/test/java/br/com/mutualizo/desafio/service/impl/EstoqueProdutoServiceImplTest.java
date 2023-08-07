package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.service.IBuscarProdutoService;
import br.com.mutualizo.desafio.util.MockUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EstoqueProdutoServiceImplTest {

    @InjectMocks
    private EstoqueProdutoServiceImpl estoqueProdutoService;
    @Mock
    private IBuscarProdutoService buscarProdutoService;
    @Mock
    private IResponseMapper<EstoqueProdutoResponse, Produto> responseMapper;

    @Test
    @DisplayName("Dado um produto valido quando buscar estoque então deve retornar estoque atual")
    public void dadoUmProdutoValidoQuandoBuscarQuantidadeEmEstoqueEntaoDeveRetornarEstoqueAtual() {
        Long idProduto = 1L;
        Produto produto = MockUtil.getProduto();
        EstoqueProdutoResponse response = MockUtil.getEstoqueProdutoResponse();
        when(buscarProdutoService.buscar(idProduto)).thenReturn(produto);
        when(responseMapper.toResponse(produto)).thenReturn(response);
        EstoqueProdutoResponse resposta = estoqueProdutoService.consultar(idProduto);
        verify(buscarProdutoService, times(1)).buscar(idProduto);
        verify(responseMapper, times(1)).toResponse(produto);
        assertEquals(response, resposta);
    }

}