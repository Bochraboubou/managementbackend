package com.example.managementbackend.Repository;

import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.ArticleRealiseeId;
import com.example.managementbackend.model.ArticleRealiseeMC;
import com.example.managementbackend.model.ArticleRealiseeMCId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRealiseeMCRepository extends JpaRepository<ArticleRealiseeMC, ArticleRealiseeMCId> {
}
