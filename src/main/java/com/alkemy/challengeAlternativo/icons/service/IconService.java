package com.alkemy.challengeAlternativo.icons.service;

import com.alkemy.challengeAlternativo.icons.dto.IconBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.entity.IconEntity;

import java.util.List;
import java.util.Set;

public interface IconService {
    IconDTO save(IconDTO dto);

    List<IconBasicDTO> getAllIcons();

    List<IconDTO> getAllIconsDetailed();

    void delete(Long id);

    List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order);

    IconEntity getEntityById(Long id);

    IconDTO update(Long id, IconDTO iconDTO);
}
