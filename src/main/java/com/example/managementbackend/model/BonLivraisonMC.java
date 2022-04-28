package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class BonLivraisonMC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotNull
    private String codeBonLivraisonMC;

    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate dateSystemeBLMC;
    @NotNull
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate dateLivraisonBLMC;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordreDeTraveaux_id", nullable = false)
    private OrdreDeTraveaux ordreDeTraveaux;

}
