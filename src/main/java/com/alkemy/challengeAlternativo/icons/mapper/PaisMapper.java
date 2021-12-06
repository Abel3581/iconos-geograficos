package com.alkemy.challengeAlternativo.icons.mapper;

import com.alkemy.challengeAlternativo.icons.dto.IconBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.dto.PaisBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class PaisMapper {

    @Autowired
    private IconMapper iconMapper;

    public PaisEntity paisDTO2Entity(PaisDTO dto, boolean loadIcons) {
        PaisEntity paisEntity = new PaisEntity();
        paisEntity.setImagen(dto.getImagen());
        paisEntity.setDenominacion(dto.getDenominacion());
        paisEntity.setCantidadHabitantes(dto.getCantidadHabitantes());
        paisEntity.setSuperficie(dto.getSuperficie());
        paisEntity.setContinenteId(dto.getContinenteId());
        if (loadIcons) {
            Set<IconEntity> icons = iconMapper.iconDTOList2EntityList(dto.getIcons());
            paisEntity.setIcons(icons);
        }
        return paisEntity;
    }

    public PaisDTO paisEntity2DTO(PaisEntity entity, boolean loadIcons) {
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setContinenteId(entity.getContinenteId());
        dto.setSuperficie(entity.getSuperficie());
        if (loadIcons) {
            List<IconDTO> iconDTOS = iconMapper.iconEntitySet2DTOList(entity.getIcons(), false);
            dto.setIcons(iconDTOS);
        }
        return dto;
    }

    public List<PaisEntity> paisDTOList2EntityList(List<PaisDTO> dtos) {
        List<PaisEntity> paisEntities = new ArrayList<>();
        for (PaisDTO dto : dtos){
            paisEntities.add(paisDTO2Entity(dto, false));
        }
        return paisEntities;
    }

    public List<PaisDTO> paisEntityList2DTOList(List<PaisEntity> entities, boolean loadIcons) {
        List<PaisDTO> dtos = new ArrayList<>();
        for (PaisEntity entity : entities) {
            dtos.add(paisEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }

    public List<PaisBasicDTO> paisEntityList2BasicDTOList(List<PaisEntity> entities) {
        List<PaisBasicDTO> dtos = new ArrayList<>();
        PaisBasicDTO basicDTO;
        for (PaisEntity entity : entities) {
            basicDTO = new PaisBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImagen(entity.getImagen());
            basicDTO.setDenominacion(entity.getDenominacion());
            basicDTO.setCantidadHabitantes(entity.getCantidadHabitantes());
        }
        return dtos;
    }

    public void paisEntityRefreshValues(PaisEntity entity, PaisDTO paisDTO) {
        entity.setImagen(paisDTO.getImagen());
        entity.setDenominacion(paisDTO.getDenominacion());
        entity.setCantidadHabitantes(paisDTO.getCantidadHabitantes());
        entity.setSuperficie(paisDTO.getSuperficie());
        entity.setContinenteId(paisDTO.getContinenteId());
    }

}
