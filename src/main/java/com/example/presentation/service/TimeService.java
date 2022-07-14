package com.example.presentation.service;

import com.example.presentation.model.Tecnico;
import com.example.presentation.model.Time;
import com.example.presentation.repository.JogadorRepository;
import com.example.presentation.repository.TecnicoRepository;
import com.example.presentation.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    TimeRepository timeRepository;

    @Autowired
    TecnicoRepository tecnicoRepository;

    @Autowired
    JogadorRepository jogadorRepository;

    public Time findById(Long id) {

        Optional<Time> obj = timeRepository.findById(id);
        return obj.get();
    }

    public List<Time> findAll() {
        return timeRepository.findAll();
    }

    public Time save(Time time) {
        return timeRepository.save(time);
    }

    public void delete(Long id) {

        timeRepository.deleteById(id);

    }

    public void update(Long idTecnico, Long idTime) {
        Optional<Tecnico> tec = tecnicoRepository.findById(idTecnico);
        timeRepository.findById(idTime).map(existTime -> {
            existTime.setId(existTime.getId());
            existTime.setTecnico(tec.get());
            timeRepository.save(existTime);
            return existTime;
        }).orElseThrow(() -> new RuntimeException());
    }



}
