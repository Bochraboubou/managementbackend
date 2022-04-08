package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.Service.ArticleService;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.Metier;
import com.example.managementbackend.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @GetMapping("/articles")
    public List<Article> getAllArticles() {
        return articleService.getAll();
    }

    @GetMapping("/metiers/{metierId}/articles")
    public List<Article> getAllArticlesByMetierId(@PathVariable(value = "metierId") Long metierId) {
        return articleService.getAllArticlesByMetier(metierId);
    }

    @GetMapping("/type/{typeId}/articles")
    public List<Article> getAllArticlesByTypeId(@PathVariable(value = "typeId") Long typeId) {
        return articleService.getAllArticlesByType(typeId);
    }

    @GetMapping("/articlesbycode/{code}")
    public Optional<Article> getArticlebyCode(@PathVariable String code) {
        return articleService.getArticlebyCode(code);
    }

    @GetMapping("/articlesbyid/{id}")
    public Optional<Article> getArticlebyId(@PathVariable long id) {
        return articleService.getArticlebyId(id);
    }

    @GetMapping("/articlesbycode/{code}/metier/{metierId}")
    public Optional<Article> getArticlebyCodeandMetierId(@PathVariable(value = "code") String code,@PathVariable(value = "metierId") long metierId) {
        return articleService.getArticlebyCodeandMetier(code,metierId);
    }

    @PostMapping("/metier/{metierId}/type/{typeId}/article")
    public Article createArticle(@PathVariable (value = "metierId") Long metierId,@PathVariable (value = "typeId") Long typeId,
                               @Valid @RequestBody Article article) {
        return articleService.save(metierId,article,typeId);
    }

    @PutMapping("/editArticle/{articleId}")
    public Article updateMetier(@PathVariable Long articleId, @Valid @RequestBody Article articleRequest) {
        return articleService.updateArticle(articleId,articleRequest);
    }

    @DeleteMapping("/articles/{articleId}")
    public ResponseEntity<?> deleteArticle(@PathVariable (value = "articleId") Long articleId) {

        return articleService.delete(articleId);
    }







}


