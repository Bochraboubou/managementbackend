package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.*;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.ArticleRealiseeId;
import com.example.managementbackend.model.ArticleUtilisee;
import com.example.managementbackend.model.AticleUtiliseeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleRealiseeService {
    @Autowired
    private ArticleRealiseeRepository articleRealiseeRepo;

    @Autowired
    private AttachementRepository attachementRepo;

    @Autowired
    private ArticleRepository articleRepo;


    public List<ArticleRealisee> getAll() {
        return articleRealiseeRepo.findAll();
    }

    public ArticleRealisee create(Long attachementId,Long articleid,ArticleRealisee articleRealisee) {
        return attachementRepo.findById(attachementId).map(attachement -> {
            return articleRepo.findById(articleid).map(article -> {
                articleRealisee.setId(new ArticleRealiseeId(attachementId,articleid));
                articleRealisee.setAttachement(attachement);
                articleRealisee.setArticle(article);
                return articleRealiseeRepo.save(articleRealisee);

            }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleid + " not found"));

        }).orElseThrow(() -> new ResourceNotFoundException("attachementId " + attachementId + " not found"));
    }


    // get liste of articles réalisee by id attachement
    public List<ArticleRealisee> findListeARbyAttID(Long id ){
        return articleRealiseeRepo.findByAttachementId(id);
    }
}
