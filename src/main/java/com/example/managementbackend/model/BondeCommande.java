package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@Entity
@Table(name = "bondecommande")
public class BondeCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String codebc;

    @NotNull
    private float montant;

    @NotNull
    private long delais;


    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateDebutTraveaux;

   /* @OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "id_entreprise")
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organisation_id", nullable = false)*/

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entreprise", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Organisation entreprise;


   /* @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bondecommande")
    private List<ArticleUtilisee> articlesutilisees = new ArrayList<>();
    */


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marchee_id", nullable = false)
    private Marchee marchee;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "bondecommande",cascade = CascadeType.REMOVE)
    private List<ArticleUtilisee> articlesassociation = new ArrayList<ArticleUtilisee>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bonDeCommande")
    private List<OrdreDeTraveaux> ordresdeTraveaux = new ArrayList<>();



    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bonDeCommande")
    private List<Attachement> attachements = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "bonDeCommande")
    private List<BonLivraisonProjet> bonDeLivraisonProjet = new ArrayList<>();



    public BondeCommande(String codebc, float montant, long delais, LocalDate dateDebutTraveaux, Organisation entreprise, Marchee marchee, List<ArticleUtilisee> articlesassociation, List<Attachement> attachements) {
        this.codebc = codebc;
        this.montant = montant;
        this.delais = delais;
        this.dateDebutTraveaux = dateDebutTraveaux;
        this.entreprise = entreprise;
        this.marchee = marchee;
        this.articlesassociation = articlesassociation;
        this.attachements = attachements;
    }

    public BondeCommande() {

    }


}
