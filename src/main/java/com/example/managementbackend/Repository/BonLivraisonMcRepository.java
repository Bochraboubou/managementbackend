package com.example.managementbackend.Repository;

import com.example.managementbackend.model.BonLivraisonMC;
import com.example.managementbackend.model.BonLivraisonProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonLivraisonMcRepository extends JpaRepository<BonLivraisonMC,Long > {
    List<BonLivraisonMC> findByOrdreDeTraveauxId(long otID);
}
