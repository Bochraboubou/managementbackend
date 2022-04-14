package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.ArticleUtiliseeRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Service.ArticleUtiliseeService;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.ArticleUtilisee;
import com.example.managementbackend.model.AticleUtiliseeId;
import com.example.managementbackend.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class ArticleUtiliseeController {
    @Autowired
    private ArticleUtiliseeService articleUtiliseeService;



    @GetMapping("/articlesutilisees")
    public List<ArticleUtilisee> getAllArticlesutilisees() {
        return articleUtiliseeService.getAll();
    }

//get article utulisé bu Bon de commande  id

    @GetMapping("/bondecommande/{bcId}/articlesutilisees")
    public List<ArticleUtilisee> getAllArticlesutiliseesByBcId(@PathVariable(value = "bcId") long bcId) {
        return articleUtiliseeService.getAllArticlesutiliseesByBcId(bcId);
    }

    @GetMapping("/article/{articleId}/articlesutilisees")
    public List<ArticleUtilisee> getAllArticlesutiliseesByArticleId(@PathVariable(value = "articleId") long articleId) {
        return articleUtiliseeService.getAllArticlesutiliseesByArticleId(articleId);
    }

    @GetMapping("/bondecommande/{bcId}/articlesutilisees/{artId}")
    public Optional<ArticleUtilisee> getArticleUtiliseeByBcIdandArtId(@PathVariable Long bcId,@PathVariable Long artId) {
        return articleUtiliseeService.getArticleUtiliseeByBcIdandArtId(bcId,artId);
    }


    @PostMapping("/bondescommande/{bcId}/article/{articleid}/articlesutilisee")
    public ArticleUtilisee createArticleUtilisee(@PathVariable (value = "bcId") Long bcId, @PathVariable (value = "articleid") Long articleid,
                                 @Valid @RequestBody ArticleUtilisee articleutilisee) {
        return articleUtiliseeService.create(bcId, articleid, articleutilisee);
    }
    @GetMapping("/bc/{bcId}")
    public ArticleUtilisee getArticleUtiliseeByBCid(@PathVariable (value = "bcId") Long bcId) {
        return articleUtiliseeService.getArticlesUtulisee(bcId);
    }
}
