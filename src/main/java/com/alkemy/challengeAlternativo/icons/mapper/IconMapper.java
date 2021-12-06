package com.alkemy.challengeAlternativo.icons.mapper;

import com.alkemy.challengeAlternativo.icons.dto.IconBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class IconMapper {

    @Autowired
    private PaisMapper paisMapper;

    public IconEntity iconDTO2Entity(IconDTO dto, boolean loadPaises) {
        IconEntity iconEntity = new IconEntity();
        iconEntity.setImagen(dto.getImagen());
        iconEntity.setDenominacion(dto.getDenominacion());
        iconEntity.setFechaCreacion(string2LocalDate(dto.getFechaCreacion()));
        iconEntity.setAltura(dto.getAltura());
        iconEntity.setHistoria(dto.getHistoria());
        if (loadPaises) {
            List<PaisEntity> paises = paisMapper.paisDTOList2EntityList(dto.getPaises());
            iconEntity.setPaises(paises);
        }
        return iconEntity;
    }

    public IconDTO iconEntity2DTO(IconEntity entity, boolean loadPaises) {
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setDenominacion(entity.getDenominacion());
        dto.setFechaCreacion(entity.getFechaCreacion().toString());
        dto.setAltura(entity.getAltura());
        dto.setHistoria(entity.getHistoria());
        if (loadPaises) {
            List<PaisDTO> paisesDTO = paisMapper.paisEntityList2DTOList(entity.getPaises(), false);
            dto.setPaises(paisesDTO);
        }
        return dto;
    }

    public Set<IconEntity> iconDTOList2EntityList(List<IconDTO> icons) {
        Set<IconEntity> entities = new HashSet<>();
        for (IconDTO dto : icons){
            entities.add(iconDTO2Entity(dto, false));
        }
        return entities;
    }

    public List<IconDTO> iconEntitySet2DTOList(Collection<IconEntity> entities, boolean loadPaises) {
        List<IconDTO> dtos = new ArrayList<>();
        for (IconEntity entity : entities) {
            dtos.add(iconEntity2DTO(entity, loadPaises));
        }
        return dtos;
    }

    public List<IconBasicDTO> iconEntitySet2BasicDTOList(Collection<IconEntity> entities) {
        List<IconBasicDTO> dtos = new ArrayList<>();
        IconBasicDTO basicDTO;
        for (IconEntity entity : entities) {
            basicDTO = new IconBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImagen(entity.getImagen());
            basicDTO.setDenominacion(entity.getDenominacion());
            dtos.add(basicDTO);
        }
        return dtos;
    }

    public void iconEntityRefreshValues(IconEntity entity, IconDTO iconDTO) {
        entity.setImagen(iconDTO.getImagen());
        entity.setDenominacion(iconDTO.getDenominacion());
        entity.setFechaCreacion(string2LocalDate(iconDTO.getFechaCreacion()));
        entity.setAltura(iconDTO.getAltura());
        entity.setHistoria(iconDTO.getHistoria());
    }

    private LocalDate string2LocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }
}
