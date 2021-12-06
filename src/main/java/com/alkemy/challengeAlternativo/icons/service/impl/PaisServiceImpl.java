package com.alkemy.challengeAlternativo.icons.service.impl;

import com.alkemy.challengeAlternativo.icons.dto.PaisBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.dto.PaisFiltersDTO;
import com.alkemy.challengeAlternativo.icons.entity.PaisEntity;
import com.alkemy.challengeAlternativo.icons.exception.ParamNotFound;
import com.alkemy.challengeAlternativo.icons.mapper.PaisMapper;
import com.alkemy.challengeAlternativo.icons.repository.PaisRepository;
import com.alkemy.challengeAlternativo.icons.repository.specifications.PaisSpecification;
import com.alkemy.challengeAlternativo.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PaisServiceImpl implements PaisService {

    //Repo
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private PaisSpecification paisSpecification;

    //Mapper
    @Autowired
    private PaisMapper paisMapper;

    public PaisDTO save(PaisDTO dto) {
        PaisEntity entity = paisMapper.paisDTO2Entity(dto, true);
        PaisEntity entitySaved = paisRepository.save(entity);
        PaisDTO result = paisMapper.paisEntity2DTO(entitySaved, true);
        return result;
    }

    public PaisDTO update(Long id, PaisDTO paisDTO) {
        Optional<PaisEntity> entity = paisRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Id de pais no válido");
        }
        paisMapper.paisEntityRefreshValues(entity.get(), paisDTO);
        PaisEntity entitySaved = paisRepository.save(entity.get());
        PaisDTO result = paisMapper.paisEntity2DTO(entitySaved, false);
        return result;
    }

    public List<PaisBasicDTO> getAllPaises() {
        List<PaisEntity> entities = paisRepository.findAll();
        List<PaisBasicDTO> result = paisMapper.paisEntityList2BasicDTOList(entities);
        return result;
    }

    public List<PaisDTO> getAllPaisesDetailed() {
        List<PaisEntity> entities = paisRepository.findAll();
        List<PaisDTO> result = paisMapper.paisEntityList2DTOList(entities, true);
        return result;
    }

    public PaisEntity getEntityById(Long id) {
        return paisRepository.getById(id);
    }

    public List<PaisDTO> getByFilters(String name, Long continente, String order) {
        PaisFiltersDTO filtersDTO = new PaisFiltersDTO(name, continente, order);
        List<PaisEntity> entities = paisRepository.findAll(paisSpecification.getByFilters(filtersDTO));
        List<PaisDTO> dtos = paisMapper.paisEntityList2DTOList(entities, true);
        return dtos;
    }

    public void delete(Long id) {
        paisRepository.deleteById(id);
    }

}
