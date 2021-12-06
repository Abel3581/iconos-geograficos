package com.alkemy.challengeAlternativo.icons.service;


import com.alkemy.challengeAlternativo.icons.dto.PaisBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;

import java.util.List;

public interface PaisService {

    PaisDTO save(PaisDTO dto);

    List<PaisBasicDTO> getAllPaises();

    public List<PaisDTO> getAllPaisesDetailed();

    void delete(Long id);

    List<PaisDTO> getByFilters(String name, Long idContinente, String order);

    PaisEntity getEntityById(Long id);

    PaisDTO update(Long id, PaisDTO paisDTO);
}
