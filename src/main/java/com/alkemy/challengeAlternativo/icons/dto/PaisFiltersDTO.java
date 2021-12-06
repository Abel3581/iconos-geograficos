package com.alkemy.challengeAlternativo.icons.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisFiltersDTO {
    private String name;
    private Long continenteId;
    private String order;

    public PaisFiltersDTO(String name, Long continenteId, String order) {
        this.name = name;
        this.continenteId = continenteId;
        this.order = order;
    }

    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}
