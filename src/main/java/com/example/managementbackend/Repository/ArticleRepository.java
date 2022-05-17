package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.ArticleDTO;
import com.example.managementbackend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    //Optional<Article> findByIdAndMetierId(long id, long metierId);
    Optional<Article> findByCode(String Code);
    Optional<Article> findByCodeAndType_MetierId(String code, long metierId);
    List<Article> findByTypeId(long typeId);
    List<Article> findByType_MetierId(long metierId);






    @Query("SELECT a FROM Article a where a.code = :code and a.type.metier.id = :idMetier and (a.classe ='prestation' or a.classe ='materielFournisseur')")
    public Optional<Article> getArticlesByCodeAndMetier(@Param("code") String code,@Param("idMetier") long idMetier);



    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,au.prix,au.quantitee,t.id,t.typeLib) FROM Article a JOIN a.bcassociation au join a.type t where au.id.bondecommande_id = :bcId")
    public List<ArticleDTO> getArticlesUtilisees(@Param("bcId") long bcId);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id,a.code,a.designation,a.unitee,a.classe,t.id,t.typeLib) FROM Article  a join a.type t")
    public List<ArticleDTO> getAllArticlesJoins();

    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id,a.code,a.designation,a.unitee,a.classe, t.id,t.typeLib) FROM Article a join  a.type t join t.metier m where m.id= :metierId")
    public List<ArticleDTO> getArticlesJoinsByMetier(long metierId);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and a.classe='prestation' and at.attachement.dateAttachement between :date1 and :date2 group by a")
    public List<ArticleDTO> getArticlesRealiseesPrestationByBCbyPeriode(@Param("bcId") long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and a.classe='prestation' and at.attachement.dateAttachement = :dateA group by a")
    public List<ArticleDTO> getArticlesRealiseesPrestationByBCbyDate(@Param("bcId") long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA);

    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and a.classe='prestation' group by a")
    public List<ArticleDTO> getArticlesRealiseesPrestationGlobalbyBC(@Param("bcId") long bcId);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and a.classe='materielFournisseur' and at.attachement.dateAttachement between :date1 and :date2 group by a")
    public List<ArticleDTO> getArticlesRealiseesMFByBCbyPeriode(@Param("bcId") long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and a.classe='materielFournisseur' and at.attachement.dateAttachement = :dateA group by a")
    public List<ArticleDTO> getArticlesRealiseesMFByBCbyDate(@Param("bcId") long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA);

    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and a.classe='materielFournisseur' group by a")
    public List<ArticleDTO> getArticlesRealiseesMFGlobalbyBC(@Param("bcId") long bcId);

    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,mb.prix,mb.quantiteeLivree,t.id,t.typeLib) FROM Article a JOIN a.materielsBCdeProjet mb join a.type t where mb.bonLivraisonProjet.bl_id = :blId and a.classe='materiel En Regie'")
    public List<ArticleDTO> getMaterielsByBLdeProjet(@Param("blId") long blId);

    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,mo.prix,mo.quantiteeLivreeMC,t.id,t.typeLib) FROM Article a JOIN a.materielsBCdeMC mo join a.type t where mo.bonLivraisonMC.id = :blId and a.classe='materiel En Regie'")
    public List<ArticleDTO> getMaterielsByBLdeMC(@Param("blId") long blId);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and a.classe='materiel En Regie' and at.attachement.dateAttachement between :date1 and :date2 group by a")
    public List<ArticleDTO> getArticlesRealiseesMaterieByBCbyPeriode(@Param("bcId") long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);


    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and a.classe='materiel En Regie' and at.attachement.dateAttachement = :dateA group by a")
    public List<ArticleDTO> getArticlesRealiseesMaterielByBCbyDate(@Param("bcId") long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA);

    @Query("SELECT new com.example.managementbackend.dto.ArticleDTO(a.id, a.code,a.designation,a.unitee,sum (at.quantiteeRealisee),t.id,t.typeLib) FROM Article a JOIN a.articlesAttachees at join a.type t where at.attachement.bonDeCommande.id = :bcId and a.classe='materiel En Regie' group by a")
    public List<ArticleDTO> getArticlesRealiseesMaterielGlobalbyBC(@Param("bcId") long bcId);




    // trouver les articles by metier id where la classe est materiel
    @Query("SELECT a FROM Article a where  a.type.metier.id = :idMetier and (a.classe ='materiel En Regie' )")
    public List<Article> getArticlesByClasseAndMetier(@Param("idMetier") long idMetier);

//bochra bochra bochra bochra

}
