package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepo;

    @Autowired
    private MetierRepository metierRepo;

    public List<Article> getAll() {
        return articleRepo.findAll();
    }

    public List<Article> getAllArticlesByMetier(Long metierId) {
        return articleRepo.findByMetierId(metierId);
    }

    public Optional<Article> getArticlebyCode(String code) {
        return articleRepo.findByCode(code).map(article -> articleRepo.findByCode(code)).orElseThrow(() -> new ResourceNotFoundException("code " + code+ " not found"));
    }

    public Optional<Article> getArticlebyCodeandMetier(String code,long metierId) {
        return articleRepo.findByCodeAndMetierId(code,metierId).map(article -> articleRepo.findByCodeAndMetierId(code,metierId)).orElseThrow(() -> new ResourceNotFoundException("code " + code+ " not found ou idMetier "+ metierId+"not found "));
    }

    public Article save(Long metierId, Article article) {
        return metierRepo.findById(metierId).map(metier -> {
            article.setMetier(metier);
            return articleRepo.save(article);
        }).orElseThrow(() -> new ResourceNotFoundException("metierId " + metierId + " not found"));
    }






}
