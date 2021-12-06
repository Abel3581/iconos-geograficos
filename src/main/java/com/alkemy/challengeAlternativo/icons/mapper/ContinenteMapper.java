package com.alkemy.challengeAlternativo.icons.mapper;

import com.alkemy.challengeAlternativo.icons.dto.ContinenteDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.entity.ContinenteEntity;
import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinenteMapper {
    public ContinenteEntity continenteDTO2Entity(ContinenteDTO dto) {
        ContinenteEntity continenteEntity = new ContinenteEntity();
        continenteEntity.setImagen(dto.getImagen());
        continenteEntity.setDenominacion(dto.getDenominacion());
        return continenteEntity;
    }

    public ContinenteDTO continenteEntity2DTO(ContinenteEntity entity) {
        ContinenteDTO dto = new ContinenteDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        return dto;
    }

    public List<ContinenteDTO> continenteEntityList2DTOList(List<ContinenteEntity> entities) {
        List<ContinenteDTO> dtos = new ArrayList<>();
        for (ContinenteEntity entity : entities) {
            dtos.add(continenteEntity2DTO(entity));
        }
        return dtos;
    }

    public void continenteEntityRefreshValues(ContinenteEntity entity, ContinenteDTO continenteDTO) {
        entity.setImagen(continenteDTO.getImagen());
        entity.setDenominacion(continenteDTO.getDenominacion());
    }
}
