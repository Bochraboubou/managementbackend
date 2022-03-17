package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByMetierId(long metierId);
    Optional<Article> findByIdAndMetierId(long id, long metierId);
    Optional<Article> findByCode(String Code);
    Optional<Article> findByCodeAndMetierId(String code, long metierId);

}
