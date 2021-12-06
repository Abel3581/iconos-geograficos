package com.alkemy.challengeAlternativo.icons.controller;

import com.alkemy.challengeAlternativo.icons.dto.PaisBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.PaisDTO;
import com.alkemy.challengeAlternativo.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("paises")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping("/all")
    public ResponseEntity<List<PaisBasicDTO>> getAll() {
        List<PaisBasicDTO> paises = paisService.getAllPaises();
        return ResponseEntity.ok().body(paises);
    }
    @GetMapping("/details")
    public ResponseEntity<List<PaisDTO>> getAllDetailed() {
        List<PaisDTO> paises = paisService.getAllPaisesDetailed();
        return ResponseEntity.ok().body(paises);
    }

    @GetMapping
    public ResponseEntity<List<PaisDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long continenteId,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ) {
        List<PaisDTO> paises = paisService.getByFilters(name, continenteId, order);
        return ResponseEntity.ok(paises);
    }

    @PostMapping
    public ResponseEntity<PaisDTO> save(@RequestBody PaisDTO pais) {
        PaisDTO paisSaved = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(paisSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paisService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaisDTO> update(@PathVariable Long id, @RequestBody PaisDTO paisDTO) {
        PaisDTO result = paisService.update(id, paisDTO);
        return ResponseEntity.ok().body(result);
    }
}
