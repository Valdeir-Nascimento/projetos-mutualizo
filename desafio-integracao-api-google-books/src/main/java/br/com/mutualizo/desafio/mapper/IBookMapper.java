package br.com.mutualizo.desafio.mapper;

import br.com.mutualizo.desafio.dto.BookDTO;
import br.com.mutualizo.desafio.dto.response.BookResponse;

import java.util.List;

public interface IBookMapper {
    List<BookDTO> mapper(BookResponse bookResponse);

}
