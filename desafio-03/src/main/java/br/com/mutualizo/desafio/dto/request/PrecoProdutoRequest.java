package br.com.mutualizo.desafio.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Setter
@Getter
public class PrecoProdutoRequest {

    @NotNull
    @Positive
    private Double preco;

}
