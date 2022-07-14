package com.example.presentation.controller;

import com.example.presentation.model.Empresario;
import com.example.presentation.service.EmpresarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/empresarios")
public class EmpresarioController {

    @Autowired
    EmpresarioService empresarioService;

    @GetMapping
    public ResponseEntity<List<Empresario>> findAll() {
        List<Empresario> list = empresarioService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Empresario> findById(@PathVariable Long id) {
        Empresario obj = empresarioService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Empresario> save(@RequestBody Empresario obj) {
        obj = empresarioService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        empresarioService.delete(id);
        return ResponseEntity.noContent().build();

    }
}
