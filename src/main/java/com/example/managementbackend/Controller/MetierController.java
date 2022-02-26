package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.EntrepriseRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Entreprise;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class MetierController {
    @Autowired
    private MetierRepository metierRepo;

    @Autowired
    private SecteurRepository secteurRepo;

    @GetMapping("/secteurs/{secteurId}/metiers")
    public List<Metier> getAllMetiersBySecteurId(@PathVariable(value = "secteurId") Long secteurId) {
        return metierRepo.findBySecteurId(secteurId);
    }

    @PostMapping("/secteurs/{secteurId}/metiers")
    public Metier createMetier(@PathVariable (value = "secteurId") Long secteurId,
                                       @Valid @RequestBody Metier metier) {
        return secteurRepo.findById(secteurId).map(secteur -> {
            metier.setSecteur(secteur);
            return metierRepo.save(metier);
        }).orElseThrow(() -> new ResourceNotFoundException("secteurId " + secteurId + " not found"));
    }


    @DeleteMapping("/secteurs/{secteurId}/metiers/{metierId}")
    public ResponseEntity<?> deleteMetier(@PathVariable (value = "secteurId") Long secteurId,
                                              @PathVariable (value = "metierId") Long metierId) {
        return metierRepo.findByIdAndSecteurId(metierId, secteurId).map(metier -> {
            metierRepo.delete(metier);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("metier not found with id " + metierId+ " and secteurId " + secteurId));
    }
}




