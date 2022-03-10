package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.ArticleUtilisee;
import com.example.managementbackend.model.AticleUtiliseeId;
import com.example.managementbackend.model.Metier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleUtiliseeRepository extends JpaRepository<ArticleUtilisee, AticleUtiliseeId> {
    List<ArticleUtilisee> findAllByBondecommandeId(long bondecommandeId);
    Optional<ArticleUtilisee> findByBondecommandeIdAndArticleId(long bondecommandeId, long articleId);

}
