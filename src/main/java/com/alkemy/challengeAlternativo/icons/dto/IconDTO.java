package com.alkemy.challengeAlternativo.icons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class IconDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private String fechaCreacion;
    private Long altura;
    private String historia;
    private List<PaisDTO> paises;
}
