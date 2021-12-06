package com.alkemy.challengeAlternativo.icons.service.impl;

import com.alkemy.challengeAlternativo.icons.dto.IconBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconFiltersDTO;
import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import com.alkemy.challengeAlternativo.icons.exception.ParamNotFound;
import com.alkemy.challengeAlternativo.icons.mapper.IconMapper;
import com.alkemy.challengeAlternativo.icons.repository.IconRepository;
import com.alkemy.challengeAlternativo.icons.repository.specifications.IconSpecification;
import com.alkemy.challengeAlternativo.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IconServiceImpl implements IconService {

    //Repo
    @Autowired
    private IconRepository iconRepository;
    @Autowired
    private IconSpecification iconSpecification;

    //Mapper
    @Autowired
    private IconMapper iconMapper;

    public IconDTO save(IconDTO dto) {
        IconEntity entity = iconMapper.iconDTO2Entity(dto, true);
        IconEntity entitySaved = iconRepository.save(entity);
        IconDTO result = iconMapper.iconEntity2DTO(entitySaved, true);
        return result;
    }

    public IconDTO update(Long id, IconDTO iconDTO) {
        Optional<IconEntity> entity = iconRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Id de ícono no válido");
        }
        iconMapper.iconEntityRefreshValues(entity.get(), iconDTO);
        IconEntity entitySaved = iconRepository.save(entity.get());
        IconDTO result = iconMapper.iconEntity2DTO(entitySaved, false);
        return result;
    }

    public IconEntity getEntityById(Long id) {
        return iconRepository.getById(id);
    }

    public List<IconDTO> getAllIconsDetailed() {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconDTO> result = iconMapper.iconEntitySet2DTOList(entities, true);
        return result;
    }

    public List<IconBasicDTO> getAllIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        List<IconBasicDTO> result = iconMapper.iconEntitySet2BasicDTOList(entities);
        return result;
    }

    public void delete(Long id) {
        iconRepository.deleteById(id);
    }

    public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        IconFiltersDTO filtersDTO = new IconFiltersDTO(name, date, cities, order);
        List<IconEntity> entities = iconRepository.findAll(iconSpecification.getByFilters(filtersDTO));
        List<IconDTO> dtos = iconMapper.iconEntitySet2DTOList(entities, true);
        return dtos;
    }
}
