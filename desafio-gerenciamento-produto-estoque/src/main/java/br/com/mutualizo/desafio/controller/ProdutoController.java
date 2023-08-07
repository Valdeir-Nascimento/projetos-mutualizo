package br.com.mutualizo.desafio.controller;

import br.com.mutualizo.desafio.controller.openapi.ProdutoControllerOpenApi;
import br.com.mutualizo.desafio.dto.request.PrecoProdutoRequest;
import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;
import br.com.mutualizo.desafio.dto.response.PrecoProdutoResponse;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import br.com.mutualizo.desafio.service.ICadastrarProdutoService;
import br.com.mutualizo.desafio.service.IEditarPrecoProdutoService;
import br.com.mutualizo.desafio.service.IEstoqueProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/produtos")
public class ProdutoController implements ProdutoControllerOpenApi {

    private final ICadastrarProdutoService cadastrarProdutoService;
    private final IEstoqueProdutoService estoqueProdutoService;
    private final IEditarPrecoProdutoService editarPrecoProdutoService;

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
    public ResponseEntity<PrecoProdutoResponse> editar(@PathVariable Long idProduto, @Valid @RequestBody PrecoProdutoRequest request) {
        PrecoProdutoResponse response = editarPrecoProdutoService.editar(idProduto, request);
        return ResponseEntity.ok().body(response);
    }

}
