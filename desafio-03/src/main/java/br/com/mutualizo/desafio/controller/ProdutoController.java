package br.com.mutualizo.desafio.controller;

import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import br.com.mutualizo.desafio.service.ICadastrarProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/produtos")
public class ProdutoController {

    private final ICadastrarProdutoService cadastrarProdutoService;

    public ProdutoController(ICadastrarProdutoService cadastrarProdutoService) {
        this.cadastrarProdutoService = cadastrarProdutoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrar(@Valid @RequestBody ProdutoRequest request) {
        ProdutoResponse response = cadastrarProdutoService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
