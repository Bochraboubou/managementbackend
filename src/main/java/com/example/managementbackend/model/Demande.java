package com.example.managementbackend.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

    private String documentpath;

    private  String fileName;

    @Column
    private  boolean  demandeStatus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSecteur_d_activite() {
        return secteur_d_activite;
    }

    public void setSecteur_d_activite(String secteur_d_activite) {
        this.secteur_d_activite = secteur_d_activite;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public long getTelOrg() {
        return telOrg;
    }

    public void setTelOrg(long telOrg) {
        this.telOrg = telOrg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNomDG() {
        return nomDG;
    }

    public void setNomDG(String nomDG) {
        this.nomDG = nomDG;
    }

    public long getTelDG() {
        return telDG;
    }

    public void setTelDG(long telDG) {
        this.telDG = telDG;
    }

    public String getEmailDG() {
        return emailDG;
    }

    public void setEmailDG(String emailDG) {
        this.emailDG = emailDG;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public long getTelAdmin() {
        return telAdmin;
    }

    public void setTelAdmin(long telAdmin) {
        this.telAdmin = telAdmin;
    }

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getDocumentpath() {
        return documentpath;
    }

    public void setDocumentpath(String documentpath) {
        this.documentpath = documentpath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isDemandeStatus() {
        return demandeStatus;
    }

    public void setDemandeStatus(boolean demandeStatus) {
        this.demandeStatus = demandeStatus;
    }


}
