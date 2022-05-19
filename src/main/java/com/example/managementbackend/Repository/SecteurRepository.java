package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SecteurRepository extends JpaRepository<Secteur, Long> {
    Optional<Secteur> findByNomSecteur(String nomSecteur);
    Optional<Secteur> findByMetiersId(long metiersID);

    @Query(value = "SELECT  s.nomSecteur , COUNT(m.id) FROM Secteur s , Metier m where s.id=m.secteur.id GROUP BY s.nomSecteur" )
    public List<Object> getSecteurByMetier();


}
