package br.com.mutualizo.desafio.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProdutoNaoEncontradoException(Long idProduto) {
        super(String.format("Não foi encontrado cadastro de produto com id: %d", idProduto));
    }

}
