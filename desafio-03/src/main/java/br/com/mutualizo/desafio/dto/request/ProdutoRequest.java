package br.com.mutualizo.desafio.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoRequest {

    private String nome;
    private Double preco;
    private Integer estoque;

}
