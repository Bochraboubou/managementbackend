package com.example.managementbackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartFile;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.File;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude (value= JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String nom;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String secteur_d_activite;

    @NotNull
    private String email;

    @NotNull
    private String pays;

    @NotNull
    private String region;

    @NotNull
    private String adresse;

    @NotNull
    private long telOrg;

    @NotNull
    private String type;


    @NotNull
    private String nomDG;


    @NotNull
    private long telDG;


    @NotNull
    private String emailDG;

    @com.sun.istack.NotNull
    private String nomAdmin;


    @com.sun.istack.NotNull
    private long telAdmin;


    @com.sun.istack.NotNull
    private String emailAdmin;

    private String  document;
    private byte[] logo;
    private String filename;

}
