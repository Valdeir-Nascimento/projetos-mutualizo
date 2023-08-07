package br.com.mutualizo.desafio.exception.handler;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Schema(name = "Field")
public class Field {

    @Schema(example = "preco")
    private String name;

    @Schema(example = "O preço é inválido")
    private String userMessage;
}