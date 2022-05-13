package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.BonLivraisonMcRepository;
import com.example.managementbackend.Repository.BonLivraisonRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.OrdreDeTraveauxRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.BonLivraisonMC;
import com.example.managementbackend.model.BonLivraisonProjet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BonLivraisonMcService {


    @Autowired
    private BonLivraisonMcRepository bonLivraisonMcRepository;

    @Autowired
    OrdreDeTraveauxRepository ordreDeTraveauxRepository;

    public BonLivraisonMC saveBonLaivraisonMc(Long OTid, BonLivraisonMC bonLivraisonMC) {

        log.info("saving Bon de livraison   {}to the data base ", bonLivraisonMC.getCodeBonLivraisonMC());
        return ordreDeTraveauxRepository.findById(OTid).map(ordreDeTraveaux -> {


            bonLivraisonMC.setOrdreDeTraveaux(ordreDeTraveaux);


            return bonLivraisonMcRepository.save(bonLivraisonMC);
        }).orElseThrow(() -> new ResourceNotFoundException("ordre de traveaux   " + OTid + " not found"));

    }

    public List<BonLivraisonMC> getAllblsByOtID(Long OtID) {
        return bonLivraisonMcRepository.findByOrdreDeTraveauxId(OtID);
    }
}
