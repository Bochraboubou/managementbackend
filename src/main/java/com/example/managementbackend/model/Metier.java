package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "metier")
public class Metier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nomMetier;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secteur_id", nullable = false)
    private Secteur secteur;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "metier")
    private List<Marchee> marchees = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY,
            mappedBy = "metier")
    private List<Type> types = new ArrayList<>();



    public Metier() {

    }

    public Metier(String nomMetier, Secteur secteur, List<Marchee> marchees, List<Type> types) {
        this.nomMetier = nomMetier;
        this.secteur = secteur;
        this.marchees = marchees;
        this.types = types;
    }
}
