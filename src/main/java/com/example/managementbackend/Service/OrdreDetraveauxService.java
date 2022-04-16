package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.AttachementRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.OrdreDeTraveauxRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.OrdreDeTraveaux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdreDetraveauxService {
    @Autowired
    private OrdreDeTraveauxRepository ordreRepo;

    @Autowired
    private BondeCommandeRepository bondeCommandeRepo;


    public OrdreDeTraveaux create(Long bondeCommandeId, OrdreDeTraveaux ordreDeTraveaux) {
        return bondeCommandeRepo.findById(bondeCommandeId).map(bondeCommande -> {
            ordreDeTraveaux.setBonDeCommande(bondeCommande);
            return ordreRepo.save(ordreDeTraveaux);
        }).orElseThrow(() -> new ResourceNotFoundException("bondeCommandeId " + bondeCommandeId+ " not found"));
    }
}
