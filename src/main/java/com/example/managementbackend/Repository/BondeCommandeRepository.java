package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.BondeCommandeJoin;
import com.example.managementbackend.model.Article;
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


    @Query("SELECT new com.example.managementbackend.dto.BondeCommandeJoin(b.id,b.codebc,b.montant,b.delais,e.id,e.nom) FROM  Marchee m  join m.bondes b join b.entreprise e where m.id = :marcheeId")
    public List<BondeCommandeJoin> getAllBondesCommandesJoin(@Param("marcheeId") long marcheeId);

    @Query("SELECT new com.example.managementbackend.dto.BondeCommandeJoin(b.id,b.codebc,b.montant,b.delais,e.id,e.nom) FROM BondeCommande b JOIN b.entreprise e where b.id = :bcId")
    public Optional<BondeCommandeJoin> getBondesCommandesJoin(@Param("bcId") long bcId);



}
