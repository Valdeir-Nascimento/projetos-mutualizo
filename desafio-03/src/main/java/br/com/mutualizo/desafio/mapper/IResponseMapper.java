package br.com.mutualizo.desafio.mapper;

public interface IResponseMapper<R, E> {

    R toResponse(E entity);

}
