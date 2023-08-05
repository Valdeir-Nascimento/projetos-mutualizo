package br.com.mutualizo.desafio.util;

import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
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

}
