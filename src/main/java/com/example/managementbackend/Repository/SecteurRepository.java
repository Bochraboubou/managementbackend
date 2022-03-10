package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Long> {
    Optional<Secteur> findByNomSecteur(String nomSecteur);
    Optional<Secteur> findByMetiersId(long metiersID);

}
