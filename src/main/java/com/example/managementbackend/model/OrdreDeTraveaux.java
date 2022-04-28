package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordredeTraveaux")
public class OrdreDeTraveaux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String codeOrdre;

    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate dateOrdre;

    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate dateDebutOrdre;

    @NotNull
    private long delais;

    @NotNull
    private float montant;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bondecommande_id", nullable = false)
    private BondeCommande bonDeCommande;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "ordreDeTraveaux",cascade = CascadeType.REMOVE)
    private List<OrdreDefinitif> articlesParOrdre = new ArrayList<OrdreDefinitif>();


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ordreTraveaux")
    private List<AttachementMC> attachementsMC = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ordreDeTraveaux")
    private List<BonLivraisonMC> bonLivraisonMCs = new ArrayList<>();

}
