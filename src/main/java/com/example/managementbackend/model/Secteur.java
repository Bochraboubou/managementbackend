package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "secteur")
public class Secteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String nomSecteur;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "secteur")
    private List<Metier> metiers = new ArrayList<>();


    public Secteur() {

    }

    public Secteur(String nomSecteur, List<Metier> metiers) {
        this.nomSecteur = nomSecteur;
        this.metiers = metiers;
    }
}
