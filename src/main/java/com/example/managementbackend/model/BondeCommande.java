package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bondecommande")
public class BondeCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotNull
    private long numeros;

    @NotNull
    private float montant;

    @NotNull
    private long delais;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_entreprise")
    private Entreprise entreprise;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bondecommande")
    private List<ArticleUtilisee> articlesutilisees = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marchee_id", nullable = false)
    private Marchee marchee;

    public BondeCommande(long numeros, float montant, long delais, Entreprise entreprise, List<ArticleUtilisee> articlesutilisees, Marchee marchee) {
        this.numeros = numeros;
        this.montant = montant;
        this.delais = delais;
        this.entreprise = entreprise;
        this.articlesutilisees = articlesutilisees;
        this.marchee = marchee;
    }

    public BondeCommande() {

    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    // Getters and Setters




    public long getNumeros() {
        return numeros;
    }

    public void setNumeros(long numeros) {
        this.numeros = numeros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public long getDelais() {
        return delais;
    }

    public void setDelais(long delais) {
        this.delais = delais;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }


    public List<ArticleUtilisee> getArticlesutilisees() {
        return articlesutilisees;
    }

    public void setArticlesutilisees(List<ArticleUtilisee> articlesutilisees) {
        this.articlesutilisees = articlesutilisees;
    }

    public Marchee getMarchee() {
        return marchee;
    }

    public void setMarchee(Marchee marchee) {
        this.marchee = marchee;
    }
}
