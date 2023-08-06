package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.BookDTO;
import br.com.mutualizo.desafio.dto.response.BookResponse;
import br.com.mutualizo.desafio.mapper.IBookMapper;
import br.com.mutualizo.desafio.service.IPesquisarLivroPorTituloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class PesquisarLivroPorTituloServiceImpl implements IPesquisarLivroPorTituloService {

    @Value("${api.google.books}")
    private String apiGoogleBooks;
    private final RestTemplate restTemplate;
    private final IBookMapper bookMapper;

    public PesquisarLivroPorTituloServiceImpl(RestTemplate restTemplate, IBookMapper bookMapper) {
        this.restTemplate = restTemplate;
        this.bookMapper = bookMapper;
    }

    public List<BookDTO> pesquisar(String titulo) {
        final String url = apiGoogleBooks + titulo;
        BookResponse response = restTemplate.getForObject(url, BookResponse.class);
        if (response != null && response.getItems() != null) {
            return bookMapper.mapper(response);
        }
        return Collections.emptyList();
    }

}