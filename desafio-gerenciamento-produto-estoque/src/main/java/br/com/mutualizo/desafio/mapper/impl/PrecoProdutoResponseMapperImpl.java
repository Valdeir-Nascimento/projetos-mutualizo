package br.com.mutualizo.desafio.mapper.impl;

import br.com.mutualizo.desafio.dto.response.PrecoProdutoResponse;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PrecoProdutoResponseMapperImpl implements IResponseMapper<PrecoProdutoResponse, Produto> {

    private final ModelMapper mapper;

    public PrecoProdutoResponseMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PrecoProdutoResponse toResponse(Produto entity) {
        return mapper.map(entity, PrecoProdutoResponse.class);
    }
}
