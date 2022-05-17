package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BonLivraisonProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bl_id ;

    @NotNull
    private String codeBonLivraisonProj;

    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate dateSystemeBLProj;
    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate dateLivraisonBLProj;

    private float montantBL;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bondecommande_id", nullable = false)
    private BondeCommande bonDeCommande;




}
