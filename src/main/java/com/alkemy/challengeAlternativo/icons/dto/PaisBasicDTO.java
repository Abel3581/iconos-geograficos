package com.alkemy.challengeAlternativo.icons.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class PaisBasicDTO {
    private Long id;
    private String imagen;
    private String denominacion;
    private Long cantidadHabitantes;
}
