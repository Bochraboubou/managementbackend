package com.example.managementbackend.Repository;

import com.example.managementbackend.model.OrdreDeTraveaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrdreDeTraveauxRepository extends JpaRepository<OrdreDeTraveaux, Long> {
   public List<OrdreDeTraveaux > findBybonDeCommandeId(Long id);


    @Query(value = "SELECT COALESCE(sum (ot.montant),0) FROM OrdreDeTraveaux ot where ot.bonDeCommande.id= :bcId")
    public float getMontantTotalOT(long bcId);

    Optional<OrdreDeTraveaux> findByCodeOrdreAndBonDeCommandeId(String codeOrdre, long bcId);

    List<OrdreDeTraveaux> findByBonDeCommandeId(long bcID);

}
