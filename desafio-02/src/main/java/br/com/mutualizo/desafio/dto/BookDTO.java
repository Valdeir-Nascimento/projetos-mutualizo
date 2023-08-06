package br.com.mutualizo.desafio.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookDTO {

    private String titulo;
    private List<String> autores;
    private Integer paginas;

}
