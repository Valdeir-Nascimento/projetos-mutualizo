package br.com.mutualizo.desafio.mapper.impl;

import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.mapper.IRequestMapper;
import br.com.mutualizo.desafio.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProdutoRequestMapperImpl implements IRequestMapper<ProdutoRequest, Produto> {

    private final ModelMapper mapper;

    public ProdutoRequestMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Produto toEntity(ProdutoRequest request) {
        return mapper.map(request, Produto.class);
    }
}
