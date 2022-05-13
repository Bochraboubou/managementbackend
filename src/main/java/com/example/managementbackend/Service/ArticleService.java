package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.TypeRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepo;

    @Autowired
    private MetierRepository metierRepo;

    @Autowired
    private TypeRepository typeRepo;

    public List<Article> getAll() {
        return articleRepo.findAll();
    }

    public List<Article> getAllArticlesByMetier(Long metierId) {
        return articleRepo.findByType_MetierId(metierId);
    }

    public List<Article> getAllArticlesByType(Long typeId) {
        return articleRepo.findByTypeId(typeId);
    }

    public Optional<Article> getArticlebyCode(String code) {
        return articleRepo.findByCode(code).map(article -> articleRepo.findByCode(code)).orElseThrow(() -> new ResourceNotFoundException("code " + code+ " not found"));
    }

    public Optional<Article> getArticlebyId(long id) {
        return articleRepo.findById(id).map(article -> articleRepo.findById(id)).orElseThrow(() -> new ResourceNotFoundException("id article " + id+ " not found"));
    }

    public Optional<Article> getArticlebyCodeandMetier(String code,long metierId) {
        return articleRepo.findByCodeAndType_MetierId(code,metierId).map(article -> articleRepo.findByCodeAndType_MetierId(code,metierId)).orElseThrow(() -> new ResourceNotFoundException("code " + code+ " not found ou idMetier "+ metierId+"not found "));
    }

    public Optional<Article> getArticledeclassePrestationandMaterielFournisseurbyCodeandMetier(String code,long metierId) {
        return articleRepo.getArticlesByCodeAndMetier(code,metierId).map(article -> articleRepo.getArticlesByCodeAndMetier(code,metierId)).orElseThrow(() -> new ResourceNotFoundException("code " + code+ " not found ou idMetier "+ metierId+"not found "));
    }

    public Article save( Article article,long typeId) {
            return typeRepo.findById(typeId).map(type -> {
                article.setType(type);
                return articleRepo.save(article);
            }).orElseThrow(() -> new ResourceNotFoundException("typeId " + typeId + " not found"));
    }

    public Article updateArticle(Long articleId, Article articleRequest) {
        return articleRepo.findById(articleId).map(article -> {
            article.setCode(articleRequest.getCode());
            article.setDesignation(articleRequest.getDesignation());
            article.setUnitee(articleRequest.getUnitee());
            article.setClasse((articleRequest.getClasse()));
            return articleRepo.save(article);
        }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleId + " not found"));
    }

    public ResponseEntity<?> delete(Long articleId) {

        return articleRepo.findById(articleId).map(article -> {
            articleRepo.delete(article);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleId + " not found"));
    }







}
