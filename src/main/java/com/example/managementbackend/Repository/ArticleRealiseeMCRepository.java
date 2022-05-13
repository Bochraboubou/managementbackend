package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.ArticleDTO;
import com.example.managementbackend.model.ArticleRealiseeMC;
import com.example.managementbackend.model.ArticleRealiseeMCId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;

import java.util.List;

@Repository
public interface ArticleRealiseeMCRepository extends JpaRepository<ArticleRealiseeMC, ArticleRealiseeMCId> {

    public List<ArticleRealiseeMC> findByattachementMCId(Long id);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttacheesMC at join a.type t where at.attachementMC.ordreTraveaux.id = :otId and a.classe='prestation' and at.attachementMC.dateAttachementMC between :date1 and :date2 group by a")
    public List<ArticleDTO> getArticlesRealiseesPrestationByOTbyPeriode(@Param("otId") long otId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttacheesMC at join a.type t where at.attachementMC.ordreTraveaux.id = :otId and a.classe='prestation' and at.attachementMC.dateAttachementMC = :dateA group by a")
    public List<ArticleDTO> getArticlesRealiseesPrestationByOTbyDate(@Param("otId") long otId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA);

    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttacheesMC at join a.type t where at.attachementMC.ordreTraveaux.id = :otId and a.classe='prestation' group by a")
    public List<ArticleDTO> getArticlesRealiseesPrestationGlobalbyOT(@Param("otId") long otId);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttacheesMC at join a.type t where at.attachementMC.ordreTraveaux.id = :otId and a.classe='materielFournisseur' and at.attachementMC.dateAttachementMC between :date1 and :date2 group by a")
    public List<ArticleDTO> getArticlesRealiseesMFByOTbyPeriode(@Param("otId") long otId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttacheesMC at join a.type t where at.attachementMC.ordreTraveaux.id = :otId and a.classe='materielFournisseur' and at.attachementMC.dateAttachementMC = :dateA group by a")
    public List<ArticleDTO> getArticlesRealiseesMFByOTbyDate(@Param("otId") long otId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA);

    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttacheesMC at join a.type t where at.attachementMC.ordreTraveaux.id = :otId and a.classe='materielFournisseur' group by a")
    public List<ArticleDTO> getArticlesRealiseesMFGlobalbyOT(@Param("otId") long otId);
}


