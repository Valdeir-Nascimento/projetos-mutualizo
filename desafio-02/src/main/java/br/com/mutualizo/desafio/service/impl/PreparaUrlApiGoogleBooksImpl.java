package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.service.IPreparaUrlApiGoogleBooks;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class PreparaUrlApiGoogleBooksImpl implements IPreparaUrlApiGoogleBooks {

    @Value("${api.google.books}")
    private String apiGoogleBooks;

    @Override
    public String preparar(String titulo) {
        return UriComponentsBuilder.fromHttpUrl(apiGoogleBooks)
                .path("/volumes")
                .queryParam("q", titulo)
                .toUriString();
    }
}
