package com.example.presentation.service;

import com.example.presentation.model.Tecnico;
import com.example.presentation.repository.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TecnicoService {

    @Autowired
    TecnicoRepository tecnicoRepository;


    public Tecnico findById(Long id) {

        Optional<Tecnico> obj = tecnicoRepository.findById(id);
        return obj.get();
    }

    public List<Tecnico> findAll() {
        return tecnicoRepository.findAll();
    }

    public Tecnico save(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public void delete(Long id) {

        tecnicoRepository.deleteById(id);

    }

}
