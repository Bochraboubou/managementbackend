package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.BonLivraisonRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.BonLivraisonProjet;
import com.example.managementbackend.model.BondeCommande;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BonLivraisonService {

    @Autowired
    private BonLivraisonRepository bonLivraisonRepository;

    @Autowired
    BondeCommandeRepository bondeCommandeRepository;
    @Autowired
    ArticleRepository articleRepository;

    public BonLivraisonProjet saveBonLaivraison(Long Bcid, BonLivraisonProjet bonLivraison) {

        log.info("saving Bon de livraison   {}to the data base ", bonLivraison.getCodeBonLivraisonProj());
        return bondeCommandeRepository.findById(Bcid).map(bondeCommande -> {


            bonLivraison.setBonDeCommande(bondeCommande);

           return bonLivraisonRepository.save(bonLivraison);
        }).orElseThrow(() -> new ResourceNotFoundException("bondde commande  " + Bcid + " not found"));

    }

    public List<BonLivraisonProjet> getAllblsByBcID(Long BcID) {
        return bonLivraisonRepository.findByBonDeCommandeId(BcID);
    }
    public List<Article> getArticlesByClasseAndMetierId(Long  metierId){
        return articleRepository.getArticlesByClasseAndMetier(metierId);

    }
     // get BL by code
     public BonLivraisonProjet getBLByCode(String code )
    {return  bonLivraisonRepository.findByCodeBonLivraisonProj(code);

    }
}

