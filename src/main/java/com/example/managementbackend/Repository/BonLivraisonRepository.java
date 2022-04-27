package com.example.managementbackend.Repository;

import com.example.managementbackend.model.BonLivraisonProjet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonLivraisonRepository  extends JpaRepository<BonLivraisonProjet,Long > {
}
