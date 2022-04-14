package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.ArticleUtiliseeRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.ArticleUtilisee;
import com.example.managementbackend.model.AticleUtiliseeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Service
public class ArticleUtiliseeService {
    @Autowired
    private ArticleUtiliseeRepository articleUtiliseeRepo;

    @Autowired
    private BondeCommandeRepository bondeCommandeRepo;

    @Autowired
    private ArticleRepository articleRepo;


    public List<ArticleUtilisee> getAll() {
        return articleUtiliseeRepo.findAll();
    }



    public List<ArticleUtilisee> getAllArticlesutiliseesByBcId(long bcId) {
        return articleUtiliseeRepo.findAllByBondecommandeId(bcId);
    }

    public List<ArticleUtilisee> getAllArticlesutiliseesByArticleId(long articleId) {
        return articleUtiliseeRepo.findAllByArticleId(articleId);
    }


    public Optional<ArticleUtilisee> getArticleUtiliseeByBcIdandArtId(Long bcId, Long artId) {
        return articleUtiliseeRepo.findByBondecommandeIdAndArticleId(bcId,artId).map(articleUtilisee -> articleUtiliseeRepo.findByBondecommandeIdAndArticleId(bcId,artId)).orElseThrow(() -> new ResourceNotFoundException("bcId " + bcId + " not found or articleId "+ artId +" not found" ));
    }





    public ArticleUtilisee create(Long bcId,Long articleid,ArticleUtilisee articleutilisee) {
        return bondeCommandeRepo.findById(bcId).map(bondecommande -> {
            return articleRepo.findById(articleid).map(article -> {
                articleutilisee.setId(new AticleUtiliseeId(bcId,articleid));
                articleutilisee.setBondecommande(bondecommande);
                articleutilisee.setArticle(article);
                return articleUtiliseeRepo.save(articleutilisee);

            }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleid + " not found"));

        }).orElseThrow(() -> new ResourceNotFoundException("bondecommandeId " + bcId + " not found"));
    }
    public ArticleUtilisee getArticlesUtulisee(Long id){
        return  articleUtiliseeRepo.findByBondecommandeId(id);
    }

}
