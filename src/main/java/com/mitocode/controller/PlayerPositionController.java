package com.mitocode.controller;

import com.mitocode.dto.PlayerPositionDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Player;
import com.mitocode.model.PlayerPosition;
import com.mitocode.service.IPlayerPositionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/playerposition")
public class PlayerPositionController {

    @Autowired
    private IPlayerPositionService service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<PlayerPositionDTO>> findAll() {
        List<PlayerPositionDTO> list = service.findAll().stream().map(p -> mapper.map(p, PlayerPositionDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerPositionDTO> findById(@PathVariable("id") Integer id) {
        PlayerPositionDTO dtoResponse;
        PlayerPosition obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            dtoResponse = mapper.map(obj, PlayerPositionDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PlayerPositionDTO dto) {
        PlayerPosition p = service.save(mapper.map(dto, PlayerPosition.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdPlayerPosition()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<PlayerPosition> update(@Valid @RequestBody PlayerPositionDTO dto) {
        PlayerPosition obj = service.findById(dto.getIdPlayerPosition());
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdPlayerPosition());
        }

        return new ResponseEntity<>(service.update(mapper.map(dto, PlayerPosition.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        PlayerPosition obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
