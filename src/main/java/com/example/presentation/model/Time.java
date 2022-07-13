package com.example.presentation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nacionalidade;

    @ManyToMany
    @JoinTable(name = "tb_time_campeonato", joinColumns = @JoinColumn(name = "time_id"), inverseJoinColumns = @JoinColumn(name = "campeonato_id"))
    private List<Campeonato> campeonato = new ArrayList<>();

    @OneToMany(mappedBy = "time")
    private List<Jogador> jogador;

    @OneToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;




}
