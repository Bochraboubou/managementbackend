package com.example.managementbackend.Repository;

import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.ArticleRealiseeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRealiseeRepository extends JpaRepository<ArticleRealisee, ArticleRealiseeId> {
}
