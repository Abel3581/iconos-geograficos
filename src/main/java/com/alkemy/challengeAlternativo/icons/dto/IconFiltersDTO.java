package com.alkemy.challengeAlternativo.icons.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class IconFiltersDTO {
    private String name;
    private String date;
    private Set<Long> cities;
    private String order;

    public IconFiltersDTO(String name, String date, Set<Long> cities, String order) {
        this.name = name;
        this.date = date;
        this.cities = cities;
        this.order = order;
    }

    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

}
