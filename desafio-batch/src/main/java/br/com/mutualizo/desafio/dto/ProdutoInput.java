package br.com.mutualizo.desafio.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProdutoInput {

    private Long id;
    private String nome;
    private Double preco;

}
