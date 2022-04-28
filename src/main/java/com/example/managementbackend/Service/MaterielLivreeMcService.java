package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.*;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.MaterielLivreeId;
import com.example.managementbackend.model.MaterielLivreeMCId;
import com.example.managementbackend.model.MaterielLivreePro;
import com.example.managementbackend.model.MaterielleLivreeMC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterielLivreeMcService {

    @Autowired
    MaterielLivreeMCRepository materielLivreeMCRepository;
    @Autowired
    BonLivraisonMcRepository bonLivraisonMcRepository;
    @Autowired
    ArticleRepository articleRepository;

    public MaterielleLivreeMC create(Long BLmcId, Long articleid, MaterielleLivreeMC materielLivreeMC) {
        return bonLivraisonMcRepository.findById(BLmcId).map(bonLivraisonMC-> {
            return articleRepository.findById(articleid).map(article -> {
                materielLivreeMC.setId(new MaterielLivreeMCId(BLmcId,articleid));
                materielLivreeMC.setBonLivraisonMC(bonLivraisonMC);
                materielLivreeMC.setArticle(article);
                return materielLivreeMCRepository.save(materielLivreeMC);

            }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleid + " not found"));

        }).orElseThrow(() -> new ResourceNotFoundException("bondelaivraison id  " + BLmcId + " not found"));
    }
}
