package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.BookDTO;
import br.com.mutualizo.desafio.dto.response.BookResponse;
import br.com.mutualizo.desafio.mapper.IBookMapper;
import br.com.mutualizo.desafio.service.IPesquisarLivroPorTituloService;
import br.com.mutualizo.desafio.service.IPreparaUrlApiGoogleBooks;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PesquisarLivroPorTituloServiceImpl implements IPesquisarLivroPorTituloService {

    private final RestTemplate restTemplate;
    private final IBookMapper bookMapper;
    private final IPreparaUrlApiGoogleBooks preparaUrlApiGoogleBooks;

    @Override
    public List<BookDTO> pesquisar(String titulo) {
        String url = preparaUrlApiGoogleBooks.preparar(titulo);
        BookResponse response = restTemplate.getForObject(url, BookResponse.class);
        if (response != null && response.getItems() != null) {
            return bookMapper.mapper(response);
        }
        return Collections.emptyList();
    }

}