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
        private String code;

        @NotNull
        @Column(unique = true)
        private String nom;

        @NotNull
        private String mail;

        @NotNull
        private String adresse;

        @NotNull
        private long tel;

        @NotNull
        private String gouvernerat;

        @JsonIgnore
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "organisation_id", nullable = false)
        private Organisation organisation;

        // Getters and Setters (Omitted for brevity)


        public Entreprise(String code, String nom, String mail, String adresse, long tel, String gouvernerat, Organisation organisation) {
                this.code = code;
                this.nom = nom;
                this.mail = mail;
                this.adresse = adresse;
                this.tel = tel;
                this.gouvernerat = gouvernerat;
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

        public String getMail() {
                return mail;
        }

        public void setMail(String mail) {
                this.mail = mail;
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

        public String getGouvernerat() {
                return gouvernerat;
        }

        public void setGouvernerat(String gouvernerat) {
                this.gouvernerat = gouvernerat;
        }

        public Organisation getOrganisation() {
                return organisation;
        }

        public void setOrganisation(Organisation organisation) {
                this.organisation = organisation;
        }

        public String getCode() {
                return code;
        }

        public void setCode(String code) {
                this.code = code;
        }

        @Override
        public String toString() {
                return "Entreprise{" +
                        "code='" + code + '\'' +
                        ", nom='" + nom + '\'' +
                        ", mail='" + mail + '\'' +
                        ", adresse='" + adresse + '\'' +
                        ", tel=" + tel +
                        ", gouvernerat='" + gouvernerat + '\'' +
                        ", organisation=" + organisation +
                        '}';
        }
}
