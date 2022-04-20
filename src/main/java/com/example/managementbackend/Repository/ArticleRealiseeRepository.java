package com.example.managementbackend.Repository;

import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.ArticleRealiseeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRealiseeRepository extends JpaRepository<ArticleRealisee, ArticleRealiseeId> {
    public List<ArticleRealisee>findByAttachementId(Long id );
}
