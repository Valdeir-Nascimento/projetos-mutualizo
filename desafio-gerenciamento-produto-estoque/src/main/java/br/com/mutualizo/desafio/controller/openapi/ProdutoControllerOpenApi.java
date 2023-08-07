package br.com.mutualizo.desafio.controller.openapi;

import br.com.mutualizo.desafio.dto.request.PrecoProdutoRequest;
import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;
import br.com.mutualizo.desafio.dto.response.PrecoProdutoResponse;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

@Tag(name = "Produtos")
public interface ProdutoControllerOpenApi {

    @Operation(
        summary = "Cadastra um produto",
        description = "Cadastra novo produto",
        responses = @ApiResponse(responseCode = "201")
    )
    ResponseEntity<ProdutoResponse> cadastrar(@RequestBody(description = "Representação de um produto", required = true) ProdutoRequest request);

    @Operation(summary = "Buscar estoque do produto por ID",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(
                responseCode = "400",
                description = "ID de produto inválido",
                content = @Content(schema = @Schema(ref = "JsonError"))
            )
        }
    )
    ResponseEntity<EstoqueProdutoResponse> consultarEstoque(@Parameter(description = "ID de um produto", example = "1", required = true) Long idProduto);

    @Operation(summary = "Atualiza um produto por ID",
        responses = {
            @ApiResponse(responseCode = "200"),
            @ApiResponse(
                responseCode = "400",
                description = "Id de produto inválido",
                content = @Content(schema = @Schema(ref = "JsonError"))
            )
        }
    )
    ResponseEntity<PrecoProdutoResponse> editar(
        @Parameter(description = "Id de um produto", example = "1", required = true) Long idProduto,
        @RequestBody(description = "Representação do preço do produto com o valor atualizado") PrecoProdutoRequest request
    );

}
