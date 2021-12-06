package com.alkemy.challengeAlternativo.icons.service;

import com.alkemy.challengeAlternativo.icons.dto.ContinenteDTO;

import java.util.List;

public interface ContinenteService {
    ContinenteDTO save(ContinenteDTO dto);

    List<ContinenteDTO> getAllContinentes();

    void delete(Long id);

    ContinenteDTO update(Long id, ContinenteDTO continenteDTO);
}
