package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepo;

    @Autowired
    private MetierRepository metierRepo;

    @GetMapping("/metiers/{metierrId}/articles")
    public List<Article> getAllArticlesByMetierId(@PathVariable(value = "metierId") Long metierId) {
        return articleRepo.findByMetierId(metierId);
    }

    @PostMapping("/metiers/{metierId}/articles")
    public Article createArticle(@PathVariable (value = "metierId") Long metierId,
                               @Valid @RequestBody Article article) {
        return metierRepo.findById(metierId).map(metier -> {
            article.setMetier(metier);
            return articleRepo.save(article);
        }).orElseThrow(() -> new ResourceNotFoundException("metierId " + metierId + " not found"));
    }






}


