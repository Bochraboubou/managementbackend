package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.OrdreDeTraveauxRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.OrdreDeTraveaux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class OrdreDetraveauxService {
    @Autowired
    private OrdreDeTraveauxRepository ordreRepo;

    @Autowired
    private BondeCommandeRepository bondeCommandeRepo;

    @GetMapping("/ordreById/{id}")
    public Optional<OrdreDeTraveaux> getOrdreByID(Long id){
        return ordreRepo.findById(id);
    }

    public OrdreDeTraveaux create(Long bondeCommandeId, OrdreDeTraveaux ordreDeTraveaux) {
        return bondeCommandeRepo.findById(bondeCommandeId).map(bondeCommande -> {
            ordreDeTraveaux.setBonDeCommande(bondeCommande);
            return ordreRepo.save(ordreDeTraveaux);
        }).orElseThrow(() -> new ResourceNotFoundException("bondeCommandeId " + bondeCommandeId+ " not found"));
    }

    public List<OrdreDeTraveaux> findBYBCid(Long id ){
        return ordreRepo.findBybonDeCommandeId(id);

    }
}
