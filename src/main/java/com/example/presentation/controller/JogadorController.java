package com.example.presentation.controller;

import com.example.presentation.model.Jogador;
import com.example.presentation.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorController {

    @Autowired
    JogadorService jogadorService;

    @GetMapping
    public ResponseEntity<List<Jogador>> findAll() {
        List<Jogador> list = jogadorService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Jogador> findById(@PathVariable Long id) {
        Jogador obj = jogadorService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Jogador> save(@RequestBody Jogador obj) {
        obj = jogadorService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jogadorService.delete(id);
        return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{idJogador}/{idEmpresario}")
    public ResponseEntity<Void> update(@PathVariable Long idJogador, @PathVariable Long idEmpresario) {
        jogadorService.update(idJogador, idEmpresario);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/jogatime/{idJogador}/{idTime}")
    public ResponseEntity<Void> updateJogador(@PathVariable Long idJogador, @PathVariable Long idTime) {
        jogadorService.updateJogador(idJogador, idTime);
        return ResponseEntity.noContent().build();
    }

}
