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
public class Empresario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;


    @JsonIgnore
    @OneToMany(mappedBy = "empresario")
    private List<Jogador> jogador = new ArrayList<>();

    public Empresario(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
