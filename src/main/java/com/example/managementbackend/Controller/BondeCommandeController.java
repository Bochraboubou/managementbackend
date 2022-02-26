package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.MarcheeRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.SecteurRepository;
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

    @GetMapping("/marchees/{marcheeId}/bondescommandes")
    public List<BondeCommande> getAllbcsBymarcheeId(@PathVariable(value = "marcheeId") Long marcheeId) {
        return bcRepo.findByMarcheeId(marcheeId);
    }

    @PostMapping("/marchees/{marcheeId}/bondescommandes")
    public BondeCommande createBondeCommande(@PathVariable (value = "marcheeId") Long marcheeId,
                               @Valid @RequestBody BondeCommande bondecommande) {
        return marcheeRepo.findById(marcheeId).map(marchee -> {
            bondecommande.setMarchee(marchee);
            return bcRepo.save(bondecommande);
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






