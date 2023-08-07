package br.com.mutualizo.desafio.service.impl;

import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import br.com.mutualizo.desafio.mapper.IRequestMapper;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import br.com.mutualizo.desafio.repository.IProdutoRepository;
import br.com.mutualizo.desafio.service.ICadastrarProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarProdutoServiceImpl implements ICadastrarProdutoService {

    private final IResponseMapper<ProdutoResponse, Produto> responseMapper;
    private final IRequestMapper<ProdutoRequest, Produto> requestMapper;
    private final IProdutoRepository produtoRepository;

    @Override
    public ProdutoResponse cadastrar(ProdutoRequest request) {
        Produto entity = requestMapper.toEntity(request);
        entity = produtoRepository.save(entity);
        return responseMapper.toResponse(entity);
    }

}
