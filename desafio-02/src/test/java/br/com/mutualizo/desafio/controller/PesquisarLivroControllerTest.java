package br.com.mutualizo.desafio.controller;

import br.com.mutualizo.desafio.dto.BookDTO;
import br.com.mutualizo.desafio.service.IPesquisarLivroPorTituloService;
import br.com.mutualizo.desafio.util.MockUtil;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(PesquisarLivroController.class)
class PesquisarLivroControllerTest {

    private static final String PATH = "/api/v1/livros";

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IPesquisarLivroPorTituloService pesquisarLivroPorTituloService;

    @Test
    @SneakyThrows
    @DisplayName("Dado um titulo válido quando pesquisar então deve retornar status code 200")
    public void dadoUmTituloValidoQuandoPesquisarEntaoDeveRetornarStatusCode200() {
        String titulo = MockUtil.getTitulo();
        List<BookDTO> books = MockUtil.getBooks();
        when(pesquisarLivroPorTituloService.pesquisar(titulo)).thenReturn(books);
        mockMvc.perform(get(PATH)
                    .param("titulo", titulo)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}