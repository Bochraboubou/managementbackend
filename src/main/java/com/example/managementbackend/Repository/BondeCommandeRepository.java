package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.BondeCommandeDTO;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.BonLivraisonProjet;
import com.example.managementbackend.model.BondeCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BondeCommandeRepository extends JpaRepository<BondeCommande, Long> {

    List<BondeCommande> findByMarcheeId(long marcheeId);
    Optional<BondeCommande> findByIdAndMarcheeId(long id, long marcheeId);
    Optional<BondeCommande> findByCodebc(String Codebc);



    @Query("SELECT new com.example.managementbackend.dto.BondeCommandeDTO(b.id,b.codebc,b.montant,b.delais,b.dateDebutTraveaux,e.id,e.nom) FROM  Marchee m  join m.bondes b join b.entreprise e where m.id = :marcheeId")
    public List<BondeCommandeDTO> getAllBondesCommandesJoin(@Param("marcheeId") long marcheeId);

    @Query("SELECT new com.example.managementbackend.dto.BondeCommandeDTO" +
            "(b.id,b.codebc,b.montant,b.delais,b.dateDebutTraveaux,e.id,e.nom) FROM BondeCommande b JOIN b.entreprise e where b.id = :bcId")
    public Optional<BondeCommandeDTO> getBondesCommandesJoin(@Param("bcId") long bcId);


    @Query(value = "SELECT au.bondecommande.codebc,au.bondecommande.montant, sum (au.prix * ar.quantiteeRealisee) FROM ArticleRealisee  ar join ar.article a join a.bcassociation au where au.bondecommande.marchee.id =:marcheeId and au.bondecommande.id=ar.attachement.bonDeCommande.id GROUP BY au.bondecommande")
    List<Object[]> statistiquesBCsO(@Param("marcheeId") long marcheeId);

    @Query(value = "SELECT au.bondecommande.codebc,au.bondecommande.montant, sum (au.prix * ar.quantiteeRealisee) FROM ArticleUtilisee  au ,ArticleRealisee ar where au.bondecommande.id=ar.attachement.bonDeCommande.id and au.bondecommande.marchee.id=:marcheeId  GROUP BY au.bondecommande")
    List<Object[]> statistiquesBCs(@Param("marcheeId") long marcheeId);

    @Query(value = "SELECT ar.attachementMC.ordreTraveaux.codeOrdre,ar.attachementMC.ordreTraveaux.montant, sum (au.prix * ar.quantiteeRealisee) FROM ArticleUtilisee  au ,ArticleRealiseeMC ar where au.bondecommande.id=ar.attachementMC.ordreTraveaux.bonDeCommande.id and au.bondecommande.marchee.id=:marcheeId  GROUP BY ar.attachementMC.ordreTraveaux")
    List<Object[]> statistiquesOTs(@Param("marcheeId") long marcheeId);


}
