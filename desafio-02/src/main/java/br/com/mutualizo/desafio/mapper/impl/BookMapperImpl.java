package br.com.mutualizo.desafio.mapper.impl;

import br.com.mutualizo.desafio.dto.BookDTO;
import br.com.mutualizo.desafio.dto.response.BookResponse;
import br.com.mutualizo.desafio.mapper.IBookMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapperImpl implements IBookMapper {

    @Override
    public List<BookDTO> mapper(BookResponse bookResponse) {
        List<BookDTO> books = new ArrayList<>();
        bookResponse.getItems().forEach(item -> {
            BookDTO book = new BookDTO();
            book.setTitulo(item.getVolumeInfo().getTitle());
            book.setAutores(item.getVolumeInfo().getAuthors());
            book.setPaginas(item.getVolumeInfo().getPageCount());
            books.add(book);
        });
        return books;
    }

}
