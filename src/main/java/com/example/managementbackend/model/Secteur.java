package com.example.managementbackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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


    public Secteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }

    public Secteur() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomSecteur() {
        return nomSecteur;
    }

    public void setNomSecteur(String nomSecteur) {
        this.nomSecteur = nomSecteur;
    }

    public List<Metier> getMetiers() {
        return metiers;
    }

    public void setMetiers(List<Metier> metiers) {
        this.metiers = metiers;
    }
}
