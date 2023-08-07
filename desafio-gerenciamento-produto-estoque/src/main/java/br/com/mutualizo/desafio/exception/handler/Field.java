package br.com.mutualizo.desafio.exception.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Field {

    private String name;
    private String userMessage;
}
