package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.Entreprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByMetierId(long metierId);
    Optional<Article> findByIdAndMetierId(long id, long metierId);

}
