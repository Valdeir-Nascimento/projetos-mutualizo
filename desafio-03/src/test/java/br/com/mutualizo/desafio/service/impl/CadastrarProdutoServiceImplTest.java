package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import br.com.mutualizo.desafio.mapper.IRequestMapper;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CadastrarProdutoServiceImplTest {

    @InjectMocks
    private CadastrarProdutoServiceImpl cadastrarProdutoService;
    @Mock
    private IProdutoRepository produtoRepository;
    @Mock
    private IResponseMapper<ProdutoResponse, Produto> responseMapper;
    @Mock
    private IRequestMapper<ProdutoRequest, Produto> requestMapper;
    private Produto produto;
    private ProdutoResponse response;
    private ProdutoRequest request;
    @BeforeEach
    void setup() {
        produto = MockUtil.getProduto();
        request = MockUtil.getProdutoRequest();
        response = MockUtil.getProdutoResponse();
    }

    @Test
    @DisplayName("Dado um produto valido quando cadastrar então deve retornar novo produto")
    void dadoUmProdutoValidoQuandoCadastrarEntaoDeveRetornarNovoProduto() {
        when(requestMapper.toEntity(request)).thenReturn(produto);
        when(produtoRepository.save(produto)).thenReturn(produto);
        when(responseMapper.toResponse(produto)).thenReturn(response);
        ProdutoResponse resposta = cadastrarProdutoService.cadastrar(request);
        verify(requestMapper, times(1)).toEntity(request);
        verify(produtoRepository, times(1)).save(produto);
        verify(responseMapper, times(1)).toResponse(produto);
        assertEquals(response, resposta);
    }

}