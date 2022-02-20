package com.example.managementbackend.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "organisation")

public class Organisation {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotNull
        @Column(unique = true)
        private String nom;

        @NotNull
        private String email;

        @NotNull
        private String adresse;

        @NotNull
        private long tel;

        @NotNull
        private String m_d_oeuvre;

        @NotNull
        private String m_d_oeuvrage;

        @OneToMany(cascade = CascadeType.ALL,
                fetch = FetchType.LAZY,
                mappedBy = "organisation")
        private List<Entreprise> entreprises = new ArrayList<>();

        // Getters and Setters (Omitted for brevity)

        public Organisation(String nom, String email, String adresse, long tel, String m_d_oeuvre, String m_d_oeuvrage, List<Entreprise> entreprises) {

        }

        public Organisation() {

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

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
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

        public String getM_d_oeuvre() {
                return m_d_oeuvre;
        }

        public void setM_d_oeuvre(String m_d_oeuvre) {
                this.m_d_oeuvre = m_d_oeuvre;
        }

        public String getM_d_oeuvrage() {
                return m_d_oeuvrage;
        }

        public void setM_d_oeuvrage(String m_d_oeuvrage) {
                this.m_d_oeuvrage = m_d_oeuvrage;
        }

        public List<Entreprise> getEntreprises() {
                return entreprises;
        }

        public void setEntreprises(List<Entreprise> entreprises) {
                this.entreprises = entreprises;
        }

        @Override
        public String toString() {
                return "Organisation{" +
                        "nom='" + nom + '\'' +
                        ", email='" + email + '\'' +
                        ", adresse='" + adresse + '\'' +
                        ", tel=" + tel +
                        ", m_d_oeuvre='" + m_d_oeuvre + '\'' +
                        ", m_d_oeuvrage='" + m_d_oeuvrage + '\'' +
                        ", entreprises=" + entreprises +
                        '}';
        }

}

