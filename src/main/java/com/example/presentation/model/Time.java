package com.example.presentation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Time implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nacionalidade;

    @JsonIgnore
    @ManyToMany(mappedBy = "time")
    private List<Campeonato> campeonato = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "time")
    private List<Jogador> jogador = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "tecnico_id")
    private Tecnico tecnico;


    public Time(Long id, String nome, String nacionalidade) {
        this.id = id;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }
}
