package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.*;
import com.example.managementbackend.Service.BondeCommandeService;
import com.example.managementbackend.dto.ArticleR;
import com.example.managementbackend.dto.BondeCommandeJoin;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.BondeCommande;
import com.example.managementbackend.model.Marchee;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController

public class BondeCommandeController {
    @Autowired
    private BondeCommandeService bondeCommandeService;


    @GetMapping("/AllbondeCommandesJoin/{marcheeId}")
    public List<BondeCommandeJoin> getAllBondeCommandesJoin(@PathVariable long marcheeId){
        return bondeCommandeService.getAllBondeCommandesJoin(marcheeId);
    }

    @GetMapping("/bondeCommandesJoin/{bcId}")
    public Optional<BondeCommandeJoin> getBondeCommandesJoin(@PathVariable long bcId){
        return bondeCommandeService.getBondeCommandesJoin(bcId);
    }

    @GetMapping("/marchee/{marcheeId}/bondescommandes")
    public List<BondeCommande> getAllbcsBymarcheeId(@PathVariable(value = "marcheeId") Long marcheeId) {
        return bondeCommandeService.getAllbcsBymarcheeId(marcheeId);
    }

    @GetMapping("/bondescommandes")
    public List<BondeCommande> getAllbcs() {
        return bondeCommandeService.getAll();
    }

    @GetMapping("/bcsbycode/{code}")
    public Optional<BondeCommande> getBCbyCode(@PathVariable String code) {
        return bondeCommandeService.getBCbyCode(code);
    }

    @GetMapping("/bcsbyid/{id}")
    public Optional<BondeCommande> getBCbyId(@PathVariable long id) {
        return bondeCommandeService.getBCbyId(id);
    }


    @PostMapping("/marchees/{marcheeId}/bondescommandes/{entrepId}")
    public BondeCommande createBondeCommande(@PathVariable (value = "marcheeId") Long marcheeId,@PathVariable (value = "entrepId") Long entrepId,
                               @Valid @RequestBody BondeCommande bondecommande) {
        return bondeCommandeService.create(marcheeId,entrepId,bondecommande);
    }


    @DeleteMapping("/marchees/{marcheeeId}/bondescommandes/{bcId}")
    public ResponseEntity<?> deleteBondeCommande(@PathVariable (value = "marcheeId") Long marcheeId,
                                          @PathVariable (value = "bcId") Long bcId) {
        return bondeCommandeService.delete(marcheeId, bcId);
    }



}






