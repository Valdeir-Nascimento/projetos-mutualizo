//package br.com.mutualizo.desafio.controller.openapi;
//
//import br.com.mutualizo.desafio.dto.request.PrecoProdutoRequest;
//import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
//import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;
//import br.com.mutualizo.desafio.dto.response.PrecoProdutoResponse;
//import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
//import io.swagger.annotations.*;
//import org.springframework.http.ResponseEntity;
//
//@Api(tags = "Produtos")
//public interface ProdutoControllerOpenApi {
//
////    @ApiOperation("Cadastrar um produto")
////    @ApiResponses({
////        @ApiResponse(code = 201, message = "Produto cadastrado")
////    })
//    ResponseEntity<ProdutoResponse> cadastrar(@ApiParam(name = "corpo", value = "Representação de um novo produto") ProdutoRequest request);
//
////    @ApiOperation("Busca o estoque do produto")
////    @ApiResponses({
////        @ApiResponse(code = 400, message = "Id do produto inválido"),
////        @ApiResponse(code = 404, message = "Produto não encontrado")
////    })
//    ResponseEntity<EstoqueProdutoResponse> consultarEstoque(@ApiParam(value = "Id de um produto") Long idProduto);
//
////    @ApiOperation("Atualiza o preço do produto")
////    @ApiResponses({
////        @ApiResponse(code = 200, message = "Preço atualizado"),
////        @ApiResponse(code = 404, message = "Produto não encontrado")
////    })
//    ResponseEntity<PrecoProdutoResponse> editar(
//        @ApiParam(value = "Id de um produto", example = "1", required = true) Long idProduto,
//        @ApiParam(name = "corpo", value = "Representação do novo preço a ser atualizado") PrecoProdutoRequest request
//    );
//
//}
