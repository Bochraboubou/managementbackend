package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.ArticleUtiliseeRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.MetierRepository;
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
    private ArticleUtiliseeRepository articleUtiliseeRepo;

    @Autowired
    private BondeCommandeRepository bondeCommandeRepo;

    @Autowired
    private ArticleRepository articleRepo;

    @GetMapping("/articlesutilisees")
    public List<ArticleUtilisee> getAllArticlesutilisees() {
        return articleUtiliseeRepo.findAll();
    }



    @GetMapping("/bondescommandes/{bcId}/articlesutilisees")
    public List<ArticleUtilisee> getAllArticlesutiliseesByBcId(@PathVariable(value = "bcId") long bcId) {
        return articleUtiliseeRepo.findAllByBondecommandeId(bcId);
    }

    @GetMapping("/bondescommandes/{bcId}/articlesutilisees/{artId}")
    public Optional<ArticleUtilisee> getArticleUtiliseeByBcIdandArtId(@PathVariable Long bcId,@PathVariable Long artId) {
        return articleUtiliseeRepo.findByBondecommandeIdAndArticleId(bcId,artId).map(articleUtilisee -> articleUtiliseeRepo.findByBondecommandeIdAndArticleId(bcId,artId)).orElseThrow(() -> new ResourceNotFoundException("bcId " + bcId + " not found or articleId "+ artId +" not found" ));
    }




    @PostMapping("/bondescommande/{bcId}/article/{articleid}/articlesutilisee")
    public ArticleUtilisee createArticleUtilisee(@PathVariable (value = "bcId") Long bcId, @PathVariable (value = "articleid") Long articleid,
                                 @Valid @RequestBody ArticleUtilisee articleutilisee) {
        return bondeCommandeRepo.findById(bcId).map(bondecommande -> {
            return articleRepo.findById(articleid).map(article -> {
                articleutilisee.setId(new AticleUtiliseeId(bcId,articleid));
                articleutilisee.setBondecommande(bondecommande);
                articleutilisee.setArticle(article);
                return articleUtiliseeRepo.save(articleutilisee);

            }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleid + " not found"));

        }).orElseThrow(() -> new ResourceNotFoundException("bondecommandeId " + bcId + " not found"));
    }

}
