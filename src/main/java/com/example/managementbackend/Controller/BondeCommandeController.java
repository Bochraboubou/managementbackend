package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.*;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.BondeCommande;
import com.example.managementbackend.model.Marchee;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController

public class BondeCommandeController {
    @Autowired
    private BondeCommandeRepository bcRepo;

    @Autowired
    private MarcheeRepository marcheeRepo;

    @Autowired
    private OrganisationRepository organisationRepo;


    @GetMapping("/marchees/{marcheeId}/bondescommandes")
    public List<BondeCommande> getAllbcsBymarcheeId(@PathVariable(value = "marcheeId") Long marcheeId) {
        return bcRepo.findByMarcheeId(marcheeId);
    }

    @GetMapping("/bondescommandes")
    public List<BondeCommande> getAllbcs() {
        return bcRepo.findAll();
    }

    @PostMapping("/marchees/{marcheeId}/bondescommandes/{entrepId}")
    public BondeCommande createBondeCommande(@PathVariable (value = "marcheeId") Long marcheeId,@PathVariable (value = "entrepId") Long entrepId,
                               @Valid @RequestBody BondeCommande bondecommande) {
        return marcheeRepo.findById(marcheeId).map(marchee -> {
            bondecommande.setMarchee(marchee);
            return organisationRepo.findById(entrepId).map(entreprise -> {
                bondecommande.setEntreprise(entreprise);
                return bcRepo.save(bondecommande);
            }).orElseThrow(() -> new ResourceNotFoundException("entrepriseId " + entrepId + " not found"));


        }).orElseThrow(() -> new ResourceNotFoundException("marcheeId " + marcheeId + " not found"));
    }


    @DeleteMapping("/marchees/{marcheeeId}/bondescommandes/{bcId}")
    public ResponseEntity<?> deleteBondeCommande(@PathVariable (value = "marcheeId") Long marcheeId,
                                          @PathVariable (value = "bcId") Long bcId) {
        return  bcRepo.findByIdAndMarcheeId(bcId, marcheeId).map(bondecommande -> {
            bcRepo.delete(bondecommande);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("bonde commande not found with id " + bcId+ " and marcheeId " + marcheeId));
    }
}






