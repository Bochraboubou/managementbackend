package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.ArticleR;
import com.example.managementbackend.dto.BondeCommandeJoin;
import com.example.managementbackend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByMetierId(long metierId);
    Optional<Article> findByIdAndMetierId(long id, long metierId);
    Optional<Article> findByCode(String Code);
    Optional<Article> findByCodeAndMetierId(String code, long metierId);
    List<Article> findByTypeId(long typeId);



    @Query("SELECT new com.example.managementbackend.dto.ArticleR(a.id, a.code,a.designation,a.unitee,au.prix,au.quantitee,t.id,t.typeLib) FROM Article a JOIN a.bcassociation au join a.type t where au.id.bondecommande_id = :bcId")
    public List<ArticleR> getArticlesUtilisees(@Param("bcId") long bcId);


    @Query("SELECT new com.example.managementbackend.dto.ArticleR(a.id,a.code,a.designation,a.unitee,t.id,t.typeLib) FROM Article  a join a.type t")
    public List<ArticleR> getAllArticlesJoins();

    @Query("SELECT new com.example.managementbackend.dto.ArticleR(a.id,a.code,a.designation,a.unitee,t.id,t.typeLib) FROM Metier m join  m.articles a join a.type t where m.id = :metierId")
    public List<ArticleR> getArticlesJoinsByMetier(long metierId);


    @Query("SELECT new com.example.managementbackend.dto.ArticleR(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and at.attachement.dateAttachement between :date1 and :date2 group by a")
    public List<ArticleR> getArticlesRealiseesByBCbyPeriode(@Param("bcId") long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);


    @Query("SELECT new com.example.managementbackend.dto.ArticleR(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and at.attachement.dateAttachement = :dateA group by a")
    public List<ArticleR> getArticlesRealiseesByBCbyDate(@Param("bcId") long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA);

    @Query("SELECT new com.example.managementbackend.dto.ArticleR(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId group by a")
    public List<ArticleR> getArticlesRealiseesGlobalbyBC(@Param("bcId") long bcId);

}
