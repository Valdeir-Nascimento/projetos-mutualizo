package br.com.mutualizo.desafio.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotNull
    @Positive
    private Double preco;

    @NotNull
    @Positive
    private Integer estoque;

}
