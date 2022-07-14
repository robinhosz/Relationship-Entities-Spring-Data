package com.example.presentation.controller;

import com.example.presentation.model.Time;
import com.example.presentation.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/times")
public class TimeController {

    @Autowired
    TimeService timeService;

    @GetMapping
    public ResponseEntity<List<Time>> findAll() {
        List<Time> list = timeService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Time> findById(@PathVariable Long id) {
        Time obj = timeService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Time> save(@RequestBody Time obj) {
        obj = timeService.save(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        timeService.delete(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping(value = "/{idTecnico}/{idTime}")
    public ResponseEntity<Void> update(@PathVariable Long idTecnico, @PathVariable Long idTime) {
        timeService.update(idTecnico, idTime);
        return ResponseEntity.noContent().build();
    }

}
