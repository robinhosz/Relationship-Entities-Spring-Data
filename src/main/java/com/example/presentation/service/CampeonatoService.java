package com.example.presentation.service;

import com.example.presentation.model.Campeonato;
import com.example.presentation.model.Time;
import com.example.presentation.repository.CampeonatoRepository;
import com.example.presentation.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampeonatoService {

    @Autowired
    CampeonatoRepository campeonatoRepository;

    @Autowired
    TimeRepository timeRepository;

    public Campeonato findById(Long id) {

        Optional<Campeonato> obj = campeonatoRepository.findById(id);
        return obj.get();
    }

    public List<Campeonato> findAll() {
        return campeonatoRepository.findAll();
    }

    public Campeonato save(Campeonato campeonato) {
        return campeonatoRepository.save(campeonato);
    }

    public void delete(Long id) {

        campeonatoRepository.deleteById(id);

    }


    public void update(Long idCampeonato, Long idTime) {
        Time time = timeRepository.findById(idTime).get();
        Campeonato campeonato = campeonatoRepository.findById(idCampeonato).get();
        campeonato.getTime().add(time);
        campeonatoRepository.save(campeonato);
    }


}
