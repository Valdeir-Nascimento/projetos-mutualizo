package br.com.mutualizo.desafio.controller;

import br.com.mutualizo.desafio.dto.BookDTO;
import br.com.mutualizo.desafio.service.IPesquisarLivroPorTituloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/livros")
public class PesquisarLivroController {

    private final IPesquisarLivroPorTituloService pesquisarLivroPorTitulo;

    public PesquisarLivroController(IPesquisarLivroPorTituloService pesquisarLivroPorTitulo) {
        this.pesquisarLivroPorTitulo = pesquisarLivroPorTitulo;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> pesquisar(@RequestParam @NotBlank String titulo) {
        List<BookDTO> books = pesquisarLivroPorTitulo.pesquisar(titulo);
        return ResponseEntity.ok().body(books);
    }

}
