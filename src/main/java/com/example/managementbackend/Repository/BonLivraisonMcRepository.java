package com.example.managementbackend.Repository;

import com.example.managementbackend.model.BonLivraisonMC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonLivraisonMcRepository extends JpaRepository<BonLivraisonMC,Long > {
}
