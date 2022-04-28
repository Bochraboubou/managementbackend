package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.AttachementRepository;
import com.example.managementbackend.Repository.OrdreDeTraveauxRepository;
import com.example.managementbackend.Repository.OrdreDefintifRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.ArticleRealiseeId;
import com.example.managementbackend.model.OrdreDefinitif;
import com.example.managementbackend.model.OrdreDefinitifId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdreDefinitifService {
    @Autowired
    private OrdreDefintifRepository ordreDefintifRepo;

    @Autowired
    private OrdreDeTraveauxRepository ordreTraveauxRepo;

    @Autowired
    private ArticleRepository articleRepo;

    public List<OrdreDefinitif> getAll() {
        return ordreDefintifRepo.findAll();
    }

    public  OrdreDefinitif create(Long ordreTraveauxId,Long articleid,OrdreDefinitif ordreDefinitif) {
        return ordreTraveauxRepo.findById(ordreTraveauxId).map(ordreTraveaux -> {
            return articleRepo.findById(articleid).map(article -> {
                ordreDefinitif.setId(new OrdreDefinitifId(ordreTraveauxId,articleid));
                ordreDefinitif.setOrdreDeTraveaux(ordreTraveaux);
                ordreDefinitif.setArticle(article);
                return ordreDefintifRepo.save(ordreDefinitif);

            }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleid + " not found"));

        }).orElseThrow(() -> new ResourceNotFoundException("ordreTraveauxId " + ordreTraveauxId + " not found"));
    }

    // liste des ordres definitive dans OT
    public List<OrdreDefinitif> ListeORDdefMC( Long id) {
        return ordreDefintifRepo.findByordreDeTraveauxId(id);
    }
}
