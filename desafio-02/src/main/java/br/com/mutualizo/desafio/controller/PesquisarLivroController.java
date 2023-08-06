package br.com.mutualizo.desafio.controller;

import br.com.mutualizo.desafio.dto.BookDTO;
import br.com.mutualizo.desafio.service.IPesquisarLivroPorTituloService;
import br.com.mutualizo.desafio.service.impl.PesquisarLivroPorTituloServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livros")
public class PesquisarLivroController {

    private final IPesquisarLivroPorTituloService pesquisarLivroPorTitulo;

    public PesquisarLivroController(PesquisarLivroPorTituloServiceImpl pesquisarLivroPorTitulo) {
        this.pesquisarLivroPorTitulo = pesquisarLivroPorTitulo;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> pesquisar(@RequestParam String titulo) {
        List<BookDTO> books = pesquisarLivroPorTitulo.pesquisar(titulo);
        return ResponseEntity.ok().body(books);
    }
    
}
