package br.com.mutualizo.desafio.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Builder
@ApiModel("JsonError")
@JsonInclude(Include.NON_NULL)
public class Problem {

    @ApiModelProperty(example = "400", position = 1)
    private Integer status;

    @ApiModelProperty(example = "2019-12-01T18:09:02.70844Z", position = 5)
    private OffsetDateTime timestamp;

    @ApiModelProperty(example = "https://mutualizo.com.br/dados-invalidos", position = 10)
    private String type;

    @ApiModelProperty(example = "Dados inválidos", position = 15)
    private String title;

    @ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", position = 20)
    private String detail;

    @ApiModelProperty(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.", position = 25)
    private String userMessage;

    @ApiModelProperty(value = "Lista de objetos ou campos que geraram o erro (opcional)", position = 30)
    private List<Field> objects;

}