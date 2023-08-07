package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.request.PrecoProdutoRequest;
import br.com.mutualizo.desafio.dto.response.PrecoProdutoResponse;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.repository.IProdutoRepository;
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
class EditarPrecoProdutoServiceImplTest {

    @InjectMocks
    private EditarPrecoProdutoServiceImpl editarPrecoProdutoService;
    @Mock
    private IProdutoRepository produtoRepository;
    @Mock
    private IResponseMapper<PrecoProdutoResponse, Produto> responseMapper;
    @Mock
    private IBuscarProdutoService buscarProdutoService;

    @Test
    @DisplayName("Dado um produto valido quando editar preço então deve retornar preço atualizado")
    public void dadoUmProdutoValidoQuandoEditarPrecoEntaoDeveRetornarNovoPrecoProduto() {
        Long idProduto = 1L;
        PrecoProdutoRequest request = MockUtil.getPrecoProdutoRequest();
        Produto produtoAtual = MockUtil.getProduto();
        Produto produtoSalvo = new Produto();
        produtoSalvo.setPreco(request.getPreco());
        PrecoProdutoResponse response = new PrecoProdutoResponse();

        when(produtoRepository.save(any(Produto.class))).thenReturn(produtoSalvo);
        when(buscarProdutoService.buscar(idProduto)).thenReturn(produtoAtual);
        when(responseMapper.toResponse(produtoSalvo)).thenReturn(response);

        PrecoProdutoResponse resposta = editarPrecoProdutoService.editar(idProduto, request);
        verify(buscarProdutoService, times(1)).buscar(idProduto);
        verify(produtoRepository, times(1)).save(any(Produto.class));
        verify(responseMapper, times(1)).toResponse(produtoSalvo);
        assertEquals(response, resposta);
        assertEquals(request.getPreco(), produtoSalvo.getPreco());
    }

}