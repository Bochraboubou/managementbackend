package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.ArticleR;
import com.example.managementbackend.dto.BondeCommandeJoin;
import com.example.managementbackend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
    public List<ArticleR> getArticlesRealisees(@Param("bcId") long bcId);


    @Query("SELECT new com.example.managementbackend.dto.ArticleR(a.id,a.code,a.designation,a.unitee,t.id,t.typeLib) FROM Article  a join a.type t")
    public List<ArticleR> getAllArticlesJoins();

    @Query("SELECT new com.example.managementbackend.dto.ArticleR(a.id,a.code,a.designation,a.unitee,t.id,t.typeLib) FROM Metier m join  m.articles a join a.type t where m.id = :metierId")
    public List<ArticleR> getArticlesJoinsByMetier(long metierId);


}
