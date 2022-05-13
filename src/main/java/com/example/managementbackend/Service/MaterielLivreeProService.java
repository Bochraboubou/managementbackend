package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.BonLivraisonRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.MaterielLivreeProRepository;
import com.example.managementbackend.dto.ArticleDTO;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MaterielLivreeProService {
    @Autowired
    MaterielLivreeProRepository materielLivreeProRepository;
@Autowired
    BonLivraisonRepository bonLivraisonRepository;
@Autowired
    ArticleRepository articleRepository;

    public MaterielLivreePro create(Long BLid, Long articleid, MaterielLivreePro materielLivreePro) {
        return bonLivraisonRepository.findById(BLid).map(bonLivraisonProjet-> {
            return articleRepository.findById(articleid).map(article -> {
                materielLivreePro.setId(new MaterielLivreeId(BLid,articleid));
                materielLivreePro.setBonLivraisonProjet(bonLivraisonProjet);
                materielLivreePro.setArticle(article);
                return materielLivreeProRepository.save(materielLivreePro);

            }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleid + " not found"));

        }).orElseThrow(() -> new ResourceNotFoundException("bondelaivraison id  " + BLid + " not found"));
    }

    public List<ArticleDTO> getMaterielLivreeByBL(long blID){
        return articleRepository.getMaterielsByBLdeProjet(blID);
    }
}
