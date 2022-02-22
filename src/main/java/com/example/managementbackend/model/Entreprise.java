package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "entreprise")
public class Entreprise {

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
        private String secteur_d_activité;

        @NotNull
        private String email;

        @NotNull
        private String pays;

        @NotNull
        private String region;

        @NotNull
        private String adresse;

        @NotNull
        private long tel;

        @NotNull
        private String type;


        @NotNull
        private String nomDG;


        @NotNull
        private long telDG;


        @NotNull
        private String emailDG;


        @NotNull
        private String nomAdmin;


        @NotNull
        private long telAdmin;


        @NotNull
        private String emailAdmin;
        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "organisation_id", nullable = false)
        private Organisation organisation;

        // Getters and Setters (Omitted for brevity)


        public Entreprise(String nom, String code, String secteur_d_activité, String email, String pays, String region, String adresse, long tel, String type, String nomDG, long telDG, String emailDG, String nomAdmin, long telAdmin, String emailAdmin, Organisation organisation) {
                this.nom = nom;
                this.code = code;
                this.secteur_d_activité = secteur_d_activité;
                this.email = email;
                this.pays = pays;
                this.region = region;
                this.adresse = adresse;
                this.tel = tel;
                this.type = type;
                this.nomDG = nomDG;
                this.telDG = telDG;
                this.emailDG = emailDG;
                this.nomAdmin = nomAdmin;
                this.telAdmin = telAdmin;
                this.emailAdmin = emailAdmin;
                this.organisation = organisation;
        }

        public Entreprise() {

        }

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

        public String getSecteur_d_activité() {
                return secteur_d_activité;
        }

        public void setSecteur_d_activité(String secteur_d_activité) {
                this.secteur_d_activité = secteur_d_activité;
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

        public long getTel() {
                return tel;
        }

        public void setTel(long tel) {
                this.tel = tel;
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

        public Organisation getOrganisation() {
                return organisation;
        }

        public void setOrganisation(Organisation organisation) {
                this.organisation = organisation;
        }
}
