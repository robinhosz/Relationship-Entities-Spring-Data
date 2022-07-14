package com.example.presentation.service;

import com.example.presentation.model.Empresario;
import com.example.presentation.model.Jogador;
import com.example.presentation.model.Time;
import com.example.presentation.repository.EmpresarioRepository;
import com.example.presentation.repository.JogadorRepository;
import com.example.presentation.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    JogadorRepository jogadorRepository;

    @Autowired
    EmpresarioRepository empresarioRepository;

    @Autowired
    TimeRepository timeRepository;

    public Jogador findById(Long id) {

        Optional<Jogador> obj = jogadorRepository.findById(id);
        return obj.get();
    }

    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    public Jogador save(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public void delete(Long id) {

        jogadorRepository.deleteById(id);

    }

    public void update(Long idJogador, Long idEmpresario) {
            Optional<Empresario> emp = empresarioRepository.findById(idEmpresario);
            jogadorRepository.findById(idJogador).map(existJogador -> {
            existJogador.setId(existJogador.getId());
            existJogador.setEmpresario(emp.get());
            jogadorRepository.save(existJogador);
            return existJogador;
    }).orElseThrow(() -> new RuntimeException());
}

    public void updateJogador(Long idJogador, Long idTime) {
        Optional<Time> emp = timeRepository.findById(idTime);
        jogadorRepository.findById(idJogador).map(existJogador -> {
            existJogador.setId(existJogador.getId());
            existJogador.setTime(emp.get());
            jogadorRepository.save(existJogador);
            return existJogador;
        }).orElseThrow(() -> new RuntimeException());
    }

}

