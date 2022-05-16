package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.BonLivraisonRepository;
import com.example.managementbackend.Service.BonLivraisonService;
import com.example.managementbackend.dto.BondeCommandeDTO;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.BonLivraisonProjet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class BonLivraisonController {

    @Autowired
    private BonLivraisonService bonLivraisonService;


    @PostMapping("/addBonLivraison/{idBC}")
    public BonLivraisonProjet addBonLivraison(@RequestBody BonLivraisonProjet bonLivraison, @PathVariable Long idBC){
        return  bonLivraisonService.saveBonLaivraison(idBC,bonLivraison);
    }

    @GetMapping("/AllbonsdelivraisonsdeProjet/{bcId}")
    public List<BonLivraisonProjet> getAllbyBC(@PathVariable long bcId){
        return bonLivraisonService.getAllblsByBcID(bcId);
    }
    @GetMapping("/tousArticlesTypeMateriel/{met_id}")
    public List<Article>getMaterielArticlesBymetId(@PathVariable Long met_id){
        return  bonLivraisonService.getArticlesByClasseAndMetierId(met_id);
    }
// get BLP by code
    @GetMapping("/getByCodeBL/{code}")
    public BonLivraisonProjet getBLPByCode(@PathVariable String code){
        return  bonLivraisonService.getBLByCode(code);
    }

}
