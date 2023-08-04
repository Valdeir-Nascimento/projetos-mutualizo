package br.com.mutualizo.desafio.mapper.impl;

import br.com.mutualizo.desafio.dto.request.ProdutoRequest;
import br.com.mutualizo.desafio.mapper.ICopyToProperties;
import br.com.mutualizo.desafio.model.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CopyToPropertiesImpl implements ICopyToProperties<ProdutoRequest, Produto> {

    private final ModelMapper mapper;

    public CopyToPropertiesImpl(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void copy(ProdutoRequest source, Produto entity) {
        mapper.map(source, entity);
    }
}
