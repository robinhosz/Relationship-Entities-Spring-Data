package com.example.presentation.config;

import com.example.presentation.model.*;
import com.example.presentation.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class TestConfig {

    @Autowired
    CampeonatoRepository campeonatoRepository;
    @Autowired
    EmpresarioRepository empresarioRepository;
    @Autowired
    JogadorRepository jogadorRepository;
    @Autowired
    TecnicoRepository tecnicoRepository;

    @Autowired
    TimeRepository timeRepository;

    @Bean
    public void startDB() {
        Campeonato c1 = new Campeonato(null, "Libertadores");
        Campeonato c2 = new Campeonato(null, "Brasileirao");

        campeonatoRepository.saveAll(List.of(c1, c2));

        Empresario emp = new Empresario(null, "Allan Jesus");

        empresarioRepository.saveAll(List.of(emp));

        Time time = new Time(null, "Flamengo", "Brasil");

        timeRepository.saveAll(List.of(time));

        Jogador j = new Jogador(null, "Cara da Luva");

        jogadorRepository.saveAll(List.of(j));

        Tecnico tec = new Tecnico(null, "JJ");

        tecnicoRepository.saveAll(List.of(tec));


    }
}
