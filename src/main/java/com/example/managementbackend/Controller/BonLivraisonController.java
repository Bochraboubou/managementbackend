package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.BonLivraisonRepository;
import com.example.managementbackend.Service.BonLivraisonService;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.BonLivraisonProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class BonLivraisonController {

    @Autowired
    private BonLivraisonService bonLivraisonService;


    @PostMapping("/addBonLivraison/{idBC}")
    public BonLivraisonProjet addBonLivraison(@RequestBody BonLivraisonProjet bonLivraison, @PathVariable Long idBC){
        return  bonLivraisonService.saveBonLaivraison(idBC,bonLivraison);
    }

}
