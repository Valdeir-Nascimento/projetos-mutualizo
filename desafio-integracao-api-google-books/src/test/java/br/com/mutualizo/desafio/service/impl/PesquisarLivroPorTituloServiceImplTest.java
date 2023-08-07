package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.BookDTO;
import br.com.mutualizo.desafio.dto.response.BookResponse;
import br.com.mutualizo.desafio.mapper.IBookMapper;
import br.com.mutualizo.desafio.service.IPreparaUrlApiGoogleBooks;
import br.com.mutualizo.desafio.util.MockUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PesquisarLivroPorTituloServiceImplTest {

    private PesquisarLivroPorTituloServiceImpl livroService;
    @Mock
    private RestTemplate restTemplate;
    @Mock
    private IBookMapper bookMapper;
    @Mock
    private IPreparaUrlApiGoogleBooks preparaUrlApiGoogleBooks;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        livroService = new PesquisarLivroPorTituloServiceImpl(restTemplate, bookMapper, preparaUrlApiGoogleBooks);
    }

    @Test
    @DisplayName("Dado um titulo valido quando pesquisar então deve retornar livros filtrados")
    public void dadoUmTituloValidoQuandoPesquisarEntaoDeveRetornarLivros() {
        String titulo = MockUtil.getTitulo();
        String url = MockUtil.getUrlApiGoogleBooks();
        BookResponse bookResponse = MockUtil.getBookResponse();
        List<BookDTO> expectedBooks = MockUtil.getBooks();

        when(preparaUrlApiGoogleBooks.preparar(titulo)).thenReturn(url);
        when(restTemplate.getForObject(url, BookResponse.class)).thenReturn(bookResponse);
        when(bookMapper.mapper(any())).thenReturn(expectedBooks);

        List<BookDTO> books = livroService.pesquisar(titulo);

        assertFalse(books.isEmpty());
        verify(preparaUrlApiGoogleBooks, times(1)).preparar(titulo);
        verify(restTemplate, times(1)).getForObject(url, BookResponse.class);
        verify(bookMapper, times(1)).mapper(bookResponse);
    }

    @Test
    @DisplayName("Dado um titulo invalido quando pesquisar então deve retornar uma lista vazia")
    public void dadoUmTituloInvalidoQuandoPesquisarEntaoDeveRetornaListaVazia() {
        String titulo = "Livro não encontrado";
        String url = MockUtil.getUrlApiGoogleBooks();
        when(preparaUrlApiGoogleBooks.preparar(titulo)).thenReturn(url);
        when(restTemplate.getForObject(url, BookResponse.class)).thenReturn(null);

        List<BookDTO> books = livroService.pesquisar(titulo);

        assertEquals(Collections.emptyList(), books);
        verify(preparaUrlApiGoogleBooks, times(1)).preparar(titulo);
        verify(restTemplate, times(1)).getForObject(url, BookResponse.class);
        verify(bookMapper, never()).mapper(any());
    }
}