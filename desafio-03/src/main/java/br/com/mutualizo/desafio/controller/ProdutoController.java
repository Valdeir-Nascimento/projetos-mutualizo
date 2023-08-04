package br.com.mutualizo.desafio.controller;

import br.com.mutualizo.desafio.dto.PrecoProdutoDTO;
import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import br.com.mutualizo.desafio.service.ICadastrarProdutoService;
import br.com.mutualizo.desafio.service.IEditarPrecoProdutoService;
import br.com.mutualizo.desafio.service.IEstoqueProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/produtos")
public class ProdutoController {

    private final ICadastrarProdutoService cadastrarProdutoService;
    private final IEstoqueProdutoService estoqueProdutoService;
    private final IEditarPrecoProdutoService editarPrecoProdutoService;

    public ProdutoController(
        ICadastrarProdutoService cadastrarProdutoService,
        IEstoqueProdutoService estoqueProdutoService,
        IEditarPrecoProdutoService editarPrecoProdutoService) {
        this.cadastrarProdutoService = cadastrarProdutoService;
        this.estoqueProdutoService = estoqueProdutoService;
        this.editarPrecoProdutoService = editarPrecoProdutoService;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> cadastrar(@Valid @RequestBody ProdutoRequest request) {
        ProdutoResponse response = cadastrarProdutoService.cadastrar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<EstoqueProdutoResponse> consultarEstoque(@PathVariable Long idProduto) {
        EstoqueProdutoResponse response = estoqueProdutoService.consultar(idProduto);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{idProduto}")
    public ResponseEntity<PrecoProdutoDTO> editar(@PathVariable Long idProduto, @Valid @RequestBody PrecoProdutoDTO request) {
        PrecoProdutoDTO response = editarPrecoProdutoService.editar(idProduto, request);
        return ResponseEntity.ok().body(response);
    }

}
