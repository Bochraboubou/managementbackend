package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.BondeCommandeJoin;
import com.example.managementbackend.model.OrdreDeTraveaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrdreDeTraveauxRepository extends JpaRepository<OrdreDeTraveaux, Long> {

    @Query(value = "SELECT COALESCE(sum (montant),0) FROM OrdreDeTraveaux")
    public float getMontantTotalOT();
}
