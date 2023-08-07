package br.com.mutualizo.desafio.mapper;

public interface IRequestMapper<R, E> {

    E toEntity (R request);

}
