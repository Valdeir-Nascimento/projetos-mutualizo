package br.com.mutualizo.desafio.mapper.impl;

import br.com.mutualizo.desafio.dto.response.ProdutoResponse;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProdutoResponseMapperImpl implements IResponseMapper<ProdutoResponse, Produto> {

    private final ModelMapper mapper;

    public ProdutoResponseMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ProdutoResponse toResponse(Produto entity) {
        return mapper.map(entity, ProdutoResponse.class);
    }

}
