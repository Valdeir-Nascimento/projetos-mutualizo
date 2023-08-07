package br.com.mutualizo.desafio.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class JsonError {

    private Integer statusCode;
    private String timestamp;
    private String message;

}
