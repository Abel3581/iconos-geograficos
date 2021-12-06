package com.alkemy.challengeAlternativo.icons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class PaisDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long cantidadHabitantes;
    private Long superficie;
    private Long continenteId;
    private List<IconDTO> icons;

}
