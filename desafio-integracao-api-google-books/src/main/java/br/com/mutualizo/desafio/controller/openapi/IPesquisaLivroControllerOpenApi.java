package br.com.mutualizo.desafio.controller.openapi;

import br.com.mutualizo.desafio.dto.BookDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Tag(name = "Livros")
public interface IPesquisaLivroControllerOpenApi {

    @Operation(
        summary = "Pesquisar livros por título",
        description = "Pesquisa por título e retorna uma lista de livros correspondentes.",
        responses = {
            @ApiResponse(
                responseCode = "200",
                description = "Lista de livros encontrados",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = BookDTO.class))
            ),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos")
        }
    )
    ResponseEntity<List<BookDTO>> pesquisar(@Parameter(description = "Título do livro a ser pesquisado", required = true) String titulo);

}
