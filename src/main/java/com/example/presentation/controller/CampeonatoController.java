package com.example.presentation.controller;

import com.example.presentation.model.Campeonato;
import com.example.presentation.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/campeonatos")
public class CampeonatoController {

    @Autowired
    CampeonatoService campeonatoService;

    @GetMapping
    public ResponseEntity<List<Campeonato>> findAll() {
        List<Campeonato> list = campeonatoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Campeonato> findById(@PathVariable Long id) {
        Campeonato obj = campeonatoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Campeonato> save(@RequestBody Campeonato obj) {
        obj = campeonatoService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        campeonatoService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{idCampeonato}/{idTime}")
    public ResponseEntity<Void> update(@PathVariable Long idCampeonato, @PathVariable Long idTime) {
        campeonatoService.update(idCampeonato, idTime);
        return ResponseEntity.noContent().build();
    }
}
