package com.example.managementbackend.Repository;

import com.example.managementbackend.model.BonLivraisonProjet;
import com.example.managementbackend.model.BondeCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonLivraisonRepository  extends JpaRepository<BonLivraisonProjet,Long > {
    List<BonLivraisonProjet> findByBonDeCommandeId(long bcID);
    BonLivraisonProjet findByCodeBonLivraisonProj( String code);

}
