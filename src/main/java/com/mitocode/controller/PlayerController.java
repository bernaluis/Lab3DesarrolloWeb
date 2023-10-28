package com.mitocode.controller;

import com.mitocode.dto.PlayerDTO;
import com.mitocode.exception.ModelNotFoundException;
import com.mitocode.model.Player;
import com.mitocode.service.IPlayerService;
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
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private IPlayerService service;
    @Autowired
    private ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<PlayerDTO>> findAll() {
        List<PlayerDTO> list = service.findAll().stream().map(p -> mapper.map(p, PlayerDTO.class)).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> findById(@PathVariable("id") Integer id) {
        PlayerDTO dtoResponse;
        Player obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            dtoResponse = mapper.map(obj, PlayerDTO.class);
        }
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody PlayerDTO dto) {
        Player p = service.save(mapper.map(dto, Player.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdPlayer()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Player> update(@Valid @RequestBody PlayerDTO dto) {
        Player obj = service.findById(dto.getIdPlayer());
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + dto.getIdPlayer());
        }

        return new ResponseEntity<>(service.update(mapper.map(dto, Player.class)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Integer id) {
        Player obj = service.findById(id);
        if (obj == null) {
            throw new ModelNotFoundException("ID NOT FOUND: " + id);
        } else {
            service.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
