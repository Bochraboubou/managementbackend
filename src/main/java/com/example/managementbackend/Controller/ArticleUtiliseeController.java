package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.ArticleUtiliseeRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.ArticleUtilisee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class ArticleUtiliseeController {
    @Autowired
    private ArticleUtiliseeRepository articleUtiliseeRepo;

    @Autowired
    private BondeCommandeRepository bondeCommandeRepo;

    @GetMapping("/bondescommandes/{bcId}/articlesutilisees")
    public List<ArticleUtilisee> getAllArticlesutiliseesByBcrId(@PathVariable(value = "bcId") Long bcId) {
        return articleUtiliseeRepo.findByBondecommandeId(bcId);
    }

    @PostMapping("/bondescommandes/{bcId}/articlesutilisees")
    public ArticleUtilisee createArticleUtilisee(@PathVariable (value = "bcId") Long bcId,
                                 @Valid @RequestBody ArticleUtilisee articleutilisee) {
        return bondeCommandeRepo.findById(bcId).map(bondecommande -> {
            articleutilisee.setBondecommande(bondecommande);
            return articleUtiliseeRepo.save(articleutilisee);
        }).orElseThrow(() -> new ResourceNotFoundException("bondecommandeId " + bcId + " not found"));
    }

}
