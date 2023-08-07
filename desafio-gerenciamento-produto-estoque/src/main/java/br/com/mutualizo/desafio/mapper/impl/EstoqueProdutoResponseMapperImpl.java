package br.com.mutualizo.desafio.mapper.impl;

import br.com.mutualizo.desafio.dto.response.EstoqueProdutoResponse;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EstoqueProdutoResponseMapperImpl implements IResponseMapper<EstoqueProdutoResponse, Produto> {

    private final ModelMapper mapper;

    public EstoqueProdutoResponseMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public EstoqueProdutoResponse toResponse(Produto entity) {
        return mapper.map(entity, EstoqueProdutoResponse.class);
    }
}
