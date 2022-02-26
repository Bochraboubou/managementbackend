package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.ArticleUtilisee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleUtiliseeRepository extends JpaRepository<ArticleUtilisee, Long> {
    List<ArticleUtilisee> findByBondecommandeId(long bondeCommandeId);
    Optional<Article> findByIdAndBondecommandeId(long id, long bondeCommandeId);

}
