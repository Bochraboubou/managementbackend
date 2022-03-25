package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Metier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MetierRepository extends JpaRepository<Metier, Long> {
    List<Metier> findBySecteurId(long SecteurId);
    Optional<Metier> findByIdAndSecteurId(long id, long SecteurId);
    Optional<Metier> findByNomMetier(String nomMetier);
}
