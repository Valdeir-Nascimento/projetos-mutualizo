package br.com.mutualizo.desafio.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PreparaUrlApiGoogleBooksImplTest {

    @InjectMocks
    private PreparaUrlApiGoogleBooksImpl preparaUrlApiGoogleBooks;

    @BeforeEach
    public void setUp() {
        ReflectionTestUtils.setField(preparaUrlApiGoogleBooks, "apiGoogleBooks", "https://www.googleapis.com/books/v1");
    }

    @Test
    @DisplayName("Dado um titulo valido quando preparar url então deve retonar url com parâmetro")
    public void dadoUmTituloValidoQuandoPrepararUrlEntaoDeveRetornarUrlComParamentro() {
        String titulo = "Harry Potter";
        String expectedUrl = "https://www.googleapis.com/books/v1/volumes?q=Harry%20Potter";
        String url = preparaUrlApiGoogleBooks.preparar(titulo);
        assertEquals(expectedUrl, url);
    }
}

