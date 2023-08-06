package br.com.mutualizo.desafio.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VolumeInfoResponse {

    private String title;
    private List<String> authors;
    private Integer pageCount;

}
