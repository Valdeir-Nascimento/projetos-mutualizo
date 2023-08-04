package br.com.mutualizo.desafio.mapper;

public interface ICopyToProperties<R, E> {

    void copy(R source, E entity);

}
