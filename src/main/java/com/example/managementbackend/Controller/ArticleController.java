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

    @GetMapping("/articlesbycode/{code}")
    public Optional<Article> getArticlebyCode(@PathVariable String code) {
        return articleService.getArticlebyCode(code);
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






}


