package com.alkemy.challengeAlternativo.icons.service.impl;

import com.alkemy.challengeAlternativo.icons.dto.ContinenteDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.entity.ContinenteEntity;
import com.alkemy.challengeAlternativo.icons.entity.IconEntity;
import com.alkemy.challengeAlternativo.icons.exception.ParamNotFound;
import com.alkemy.challengeAlternativo.icons.mapper.ContinenteMapper;
import com.alkemy.challengeAlternativo.icons.repository.ContinenteRepository;
import com.alkemy.challengeAlternativo.icons.service.ContinenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContinenteServiceImpl implements ContinenteService {

    @Autowired
    private ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepository continenteRepository;

    public ContinenteDTO save(ContinenteDTO dto) {
        ContinenteEntity entity = continenteMapper.continenteDTO2Entity(dto);
        ContinenteEntity entitySaved = continenteRepository.save(entity);
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
        return result;
    }

    public ContinenteDTO update(Long id, ContinenteDTO continenteDTO) {
        Optional<ContinenteEntity> entity = continenteRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Id de continente no válido");
        }
        continenteMapper.continenteEntityRefreshValues(entity.get(), continenteDTO);
        ContinenteEntity entitySaved = continenteRepository.save(entity.get());
        ContinenteDTO result = continenteMapper.continenteEntity2DTO(entitySaved);
        return result;
    }

    public List<ContinenteDTO> getAllContinentes() {
        List<ContinenteEntity> entities = continenteRepository.findAll();
        List<ContinenteDTO> result = continenteMapper.continenteEntityList2DTOList(entities);
        return result;
    }

    public void delete(Long id) {
        continenteRepository.deleteById(id);
    }
}
