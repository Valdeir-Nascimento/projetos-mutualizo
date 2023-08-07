package br.com.mutualizo.desafio.controller;

import br.com.mutualizo.desafio.dto.request.PrecoProdutoRequest;
import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;
import br.com.mutualizo.desafio.dto.response.PrecoProdutoResponse;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import br.com.mutualizo.desafio.exception.ProdutoNaoEncontradoException;
import br.com.mutualizo.desafio.service.ICadastrarProdutoService;
import br.com.mutualizo.desafio.service.IEditarPrecoProdutoService;
import br.com.mutualizo.desafio.service.IEstoqueProdutoService;
import br.com.mutualizo.desafio.util.MockUtil;
import br.com.mutualizo.desafio.util.ResourceUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    private static final String PATH = "/api/v1/produtos";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ICadastrarProdutoService cadastrarProdutoService;
    @MockBean
    private IEstoqueProdutoService estoqueProdutoService;
    @MockBean
    private IEditarPrecoProdutoService editarPrecoProdutoService;

    @Test
    @SneakyThrows
    @DisplayName("Dado um produto valido quando cadastrar então deve retorna produto cadastrado")
    public void dadoUmProdutoValidoQuandoCadastrarEntaoDeveRetornarProdutoCadastrado() {
        String jsonProdutoValido = ResourceUtil.getContentFromResource("/json/cadastra-produto-valido.json");
        ProdutoResponse response = MockUtil.getProdutoResponse();
        when(cadastrarProdutoService.cadastrar(any(ProdutoRequest.class))).thenReturn(response);
        mockMvc.perform(post(PATH)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonProdutoValido))
                .andExpect(status().isCreated());
    }

    @Test
    @SneakyThrows
    @DisplayName("Dado um produto inválido quando cadastrar então deve retornar error com status code 400")
    public void dadoUmProdutoInvalidoQuandoCadastrarEntaoDeveRetornarErro400BadRequest() {
        String jsonProdutoInvalido = ResourceUtil.getContentFromResource("/json/cadastra-produto-invalido.json");
        ProdutoResponse response = MockUtil.getProdutoResponse();
        when(cadastrarProdutoService.cadastrar(any(ProdutoRequest.class))).thenReturn(response);
        mockMvc.perform(post(PATH)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonProdutoInvalido))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @SneakyThrows
    @DisplayName("Dado um produto existente quando buscar por id então deve retornar estoque")
    public void dadoUmProdutoExistenteQuandoBuscarPorIdEntaoDeveRetornarEstoqueComStatus200() {
        Long idProduto = 1L;
        EstoqueProdutoResponse estoqueAtual = MockUtil.getEstoqueProdutoResponse();
        when(estoqueProdutoService.consultar(idProduto)).thenReturn(estoqueAtual);
        mockMvc.perform(get(PATH + "/{idProduto}", idProduto))
                .andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    @DisplayName("Dado um produto não existente quando buscar por id então deve retornar exception com status code 404")
    public void dadoUmProdutoExistenteQuandoConsultarPorIdEntaoDeveRetornarEstoqueComStatus404() {
        Long idProduto = 999L;
        when(estoqueProdutoService.consultar(idProduto)).thenThrow(ProdutoNaoEncontradoException.class);
        mockMvc.perform(get(PATH + "/{idProduto}", idProduto))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @SneakyThrows
    @DisplayName("Dado um produto existente quando atualizar preço então deve retornar novo preco")
    public void dadoUmProdutoExistenteQuandoAtualizarPrecoPorIdEntaoDeveRetornarNovoPreco() {
        Long idProduto = 1L;
        String jsonPreco = ResourceUtil.getContentFromResource("/json/edita-preco-valido.json");
        PrecoProdutoResponse precoAtualizado = MockUtil.getPrecoProdutoResponse();
        when(editarPrecoProdutoService.editar(eq(idProduto), any(PrecoProdutoRequest.class))).thenReturn(precoAtualizado);
        mockMvc.perform(put(PATH + "/{idProduto}", idProduto)
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPreco)).andExpect(status().isOk());
    }

    @Test
    @SneakyThrows
    @DisplayName("Dado um produto não existente quando atualizar preço então deve retornar error com status code  404")
    public void dadoUmProdutoNaoExistenteQuandoAtualizarPrecoPorIdEntaoDeveRetornarNovoPreco() {
        Long idProduto = 999L;
        String jsonPreco = ResourceUtil.getContentFromResource("/json/edita-preco-valido.json");
        when(editarPrecoProdutoService.editar(eq(idProduto), any(PrecoProdutoRequest.class))).thenThrow(ProdutoNaoEncontradoException.class);
        mockMvc.perform(put(PATH + "/{idProduto}", idProduto)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPreco)).andExpect(status().is4xxClientError());
    }

    @Test
    @SneakyThrows
    @DisplayName("Dado um produto existente quando atualizar preço com json invalido deve retornar error com status code 400")
    public void dadoUmProdutoExistenteQuandoAtualizarPrecoComJsonInvalidoEntaoDeveRetornarError400() {
        Long idProduto = 1L;
        String jsonPrecoInvalido = ResourceUtil.getContentFromResource("/json/edita-preco-invalido.json");
        when(editarPrecoProdutoService.editar(eq(idProduto), any(PrecoProdutoRequest.class))).thenThrow(ProdutoNaoEncontradoException.class);
        mockMvc.perform(put(PATH + "/{idProduto}", idProduto)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPrecoInvalido)).andExpect(status().is4xxClientError());
    }
    @Test
    @SneakyThrows
    @DisplayName("Dado um produto existente quando atualizar preço com parâmentro invalido deve retornar error com status code 400")
    public void dadoUmProdutoExistenteQuandoAtualizarPrecoComParametroInvalidoEntaoDeveRetornarError400() {
        Long idProduto = 1L;
        String jsonPreco = ResourceUtil.getContentFromResource("/json/edita-preco-valido.json");
        when(editarPrecoProdutoService.editar(eq(idProduto), any(PrecoProdutoRequest.class))).thenThrow(ProdutoNaoEncontradoException.class);
        mockMvc.perform(put(PATH + "/idProduto", idProduto)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPreco)).andExpect(status().is4xxClientError());
    }

}




