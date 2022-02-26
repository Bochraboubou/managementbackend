package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Organisation;
import com.example.managementbackend.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class SecteurController {
    @Autowired
    private SecteurRepository secteurRepo;

    @GetMapping("/secteurs")
    public List<Secteur> getAll() {
        return secteurRepo.findAll();
    }

    @PostMapping("/secteurs")
    public Secteur createSecteur(@Valid @RequestBody Secteur secteur) {
        return secteurRepo.save(secteur);
    }

    @PutMapping("/secteurs/{secteurId}")
    public Secteur updateSecteur(@PathVariable Long secteurId, @Valid @RequestBody Secteur secteurRequest) {
        return secteurRepo.findById(secteurId).map(secteur -> {
            secteur.setNomSecteur(secteurRequest.getNomSecteur());

            return secteurRepo.save(secteur);
        }).orElseThrow(() -> new ResourceNotFoundException("secteurId " + secteurId + " not found"));
    }


    @DeleteMapping("/secteurs/{secteurId}")
    public ResponseEntity<?> deleteSecteur(@PathVariable Long secteurId) {
        return secteurRepo.findById(secteurId).map(secteur -> {
            secteurRepo.delete(secteur);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + secteurId + " not found"));
    }
}

