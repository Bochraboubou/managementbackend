package com.example.managementbackend.Repository;

import com.example.managementbackend.model.OrdreDeTraveaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    List<OrdreDeTraveaux> findByBonDeCommandeMarcheeId(long marcheeId);

    @Query(value = "SELECT ar.attachementMC.ordreTraveaux.codeOrdre,ar.attachementMC.ordreTraveaux.montant, sum (au.prix * ar.quantiteeRealisee) FROM ArticleUtilisee  au ,ArticleRealiseeMC ar where au.bondecommande.id=ar.attachementMC.ordreTraveaux.bonDeCommande.id and au.bondecommande.marchee.id=:marcheeId  GROUP BY ar.attachementMC.ordreTraveaux")
    List<Object[]> statistiquesOTs(@Param("marcheeId") long marcheeId);

}
