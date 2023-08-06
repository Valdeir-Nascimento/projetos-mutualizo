package br.com.mutualizo.desafio.util;

import br.com.mutualizo.desafio.dto.BookDTO;
import br.com.mutualizo.desafio.dto.response.BookInfoResponse;
import br.com.mutualizo.desafio.dto.response.BookResponse;
import br.com.mutualizo.desafio.dto.response.VolumeInfoResponse;

import java.util.ArrayList;
import java.util.List;

public class MockUtil {

    private MockUtil() {
    }

    public static VolumeInfoResponse getVolumeInfoResponse() {
        VolumeInfoResponse volumeInfoResponse = new VolumeInfoResponse();
        volumeInfoResponse.setTitle("Sistemas Operacionais com Java");
        volumeInfoResponse.setAuthors(List.of("Abraham Silberschatz"));
        volumeInfoResponse.setPageCount(698);
        return volumeInfoResponse;
    }

    public static BookInfoResponse getBookInfoResponse() {
        BookInfoResponse bookInfoResponse = new BookInfoResponse();
        bookInfoResponse.setVolumeInfo(getVolumeInfoResponse());
        return bookInfoResponse;
    }

    public static BookResponse getBookResponse() {
        BookResponse bookResponse = new BookResponse();
        bookResponse.setItems(List.of(getBookInfoResponse()));
        return bookResponse;
    }

    public static List<BookDTO> getBooks() {
        List<BookDTO> books = new ArrayList<>();
        getBookResponse().getItems().forEach(item -> {
            BookDTO book = new BookDTO();
            book.setTitulo(item.getVolumeInfo().getTitle());
            book.setAutores(item.getVolumeInfo().getAuthors());
            book.setPaginas(item.getVolumeInfo().getPageCount());
            books.add(book);
        });
        return books;
    }

    public static String getUrlApiGoogleBooks() {
        return "https://www.googleapis.com/books/v1";
    }

    public static String getTitulo() {
        return "Java";
    }

}
