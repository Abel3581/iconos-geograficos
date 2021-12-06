package com.alkemy.challengeAlternativo.icons.controller;

import com.alkemy.challengeAlternativo.icons.dto.IconBasicDTO;
import com.alkemy.challengeAlternativo.icons.dto.IconDTO;
import com.alkemy.challengeAlternativo.icons.service.IconService;
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
import java.util.Set;

@RestController
@RequestMapping("icons")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping("/all")
    public ResponseEntity<List<IconBasicDTO>> getAll(){
        List<IconBasicDTO> icons = iconService.getAllIcons();
        return ResponseEntity.ok().body(icons);
    }
    @GetMapping("/details")
    public ResponseEntity<List<IconDTO>> getAllDetailed(){
        List<IconDTO> icons = iconService.getAllIconsDetailed();
        return ResponseEntity.ok().body(icons);
    }

    @GetMapping
    public ResponseEntity<List<IconDTO>> getDetailsByFilters(
            @RequestParam (required = false) String name,
            @RequestParam (required = false) String date,
            @RequestParam (required = false) Set<Long> cities,
            @RequestParam (required = false, defaultValue = "ASC") String order
    ){
        List<IconDTO> icons = iconService.getByFilters(name,date,cities,order);
        return ResponseEntity.ok(icons);
    }

    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon){
        IconDTO iconSaved = iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(iconSaved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO iconDTO){
        IconDTO result = iconService.update(id, iconDTO);
        return ResponseEntity.ok().body(result);
    }

}
