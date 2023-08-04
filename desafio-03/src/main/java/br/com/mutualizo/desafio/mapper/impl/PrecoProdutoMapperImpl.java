package br.com.mutualizo.desafio.mapper.impl;

import br.com.mutualizo.desafio.dto.PrecoProdutoDTO;
import br.com.mutualizo.desafio.mapper.IResponseMapper;
import br.com.mutualizo.desafio.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PrecoProdutoMapperImpl implements IResponseMapper<PrecoProdutoDTO, Produto> {

    private final ModelMapper mapper;

    public PrecoProdutoMapperImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public PrecoProdutoDTO toResponse(Produto entity) {
        return mapper.map(entity, PrecoProdutoDTO.class);
    }
}
