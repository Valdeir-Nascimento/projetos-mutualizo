package br.com.mutualizo.desafio.dto.response;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ProdutoResponse {

    private Long id;
    private String nome;
    private Double preco;
    private Integer estoque;

}
