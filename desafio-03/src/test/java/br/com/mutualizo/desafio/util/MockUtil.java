package br.com.mutualizo.desafio.util;

import br.com.mutualizo.desafio.dto.request.PrecoProdutoRequest;
import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import br.com.mutualizo.desafio.model.Produto;

public class MockUtil {

    public MockUtil() {}

    public static ProdutoRequest getProdutoRequest() {
        ProdutoRequest request = new ProdutoRequest();
        request.setNome("TV 50 Polegadas");
        request.setPreco(4999.90);
        request.setEstoque(10);
        return request;
    }

    public static Produto getProduto() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("TV 50 Polegadas");
        produto.setPreco(4999.90);
        produto.setEstoque(10);
        return produto;
    }

    public static ProdutoResponse getProdutoResponse() {
        ProdutoResponse response = new ProdutoResponse();
        response.setId(1L);
        response.setNome("TV 50 Polegadas");
        response.setPreco(4999.90);
        response.setEstoque(10);
        return response;
    }

    public static PrecoProdutoRequest getPrecoProdutoRequest() {
        PrecoProdutoRequest request = new PrecoProdutoRequest();
        request.setPreco(999.90);
        return request;
    }

}
