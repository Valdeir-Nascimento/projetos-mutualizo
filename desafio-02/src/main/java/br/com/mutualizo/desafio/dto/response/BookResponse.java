package br.com.mutualizo.desafio.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class BookResponse {

    List<BookInfoResponse> items;

}
