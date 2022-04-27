package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.BonLivraisonMcService;
import com.example.managementbackend.model.BonLivraisonMC;
import com.example.managementbackend.model.BonLivraisonProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class BonLivraisonMcController {
    @Autowired
    private BonLivraisonMcService bonLivraisonMcService;

    @PostMapping("/addBonLivraisonMc/{idOT}")
    public BonLivraisonMC addBonLivraison(@RequestBody BonLivraisonMC bonLivraisonMC, @PathVariable Long idOT){
        return  bonLivraisonMcService.saveBonLaivraisonMc(idOT,bonLivraisonMC);
    }
}
