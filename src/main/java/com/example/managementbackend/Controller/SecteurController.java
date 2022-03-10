package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.Service.SecteurService;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Organisation;
import com.example.managementbackend.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class SecteurController {
    @Autowired
    private SecteurService secteurService;

    @GetMapping("/secteurs")
    public List<Secteur> getAll() {
        return secteurService.getAll();
    }

    @GetMapping("/secteurbynom/{nomSecteur}")
    public Optional<Secteur> getSecteurbyNom(@PathVariable String nomSecteur) {
        return secteurService.getSecteurbyNom(nomSecteur);
    }

    @GetMapping("/secteurbyId/{isSecteur}")
    public Optional<Secteur> getSecteurbyId(@PathVariable long idSecteur) {
        return secteurService.getSecteurbyId(idSecteur);
    }

    @GetMapping("/secteurbymetiers/{idmetier}")
    public Optional<Secteur> getSecteurbymetiers(@PathVariable long idmetier) {
        return secteurService.getSecteurbymetiers(idmetier);
    }

    @PostMapping("/secteurs")
    public Secteur createSecteur(@Valid @RequestBody Secteur secteur) {
        return secteurService.createSecteur(secteur);
    }

    @PutMapping("/secteurs/{secteurId}")
    public Secteur updateSecteur(@PathVariable Long secteurId, @Valid @RequestBody Secteur secteurRequest) {
        return secteurService.updateSecteur(secteurId,secteurRequest);
    }


    @DeleteMapping("/secteurs/{secteurId}")
    public ResponseEntity<?> deleteSecteur(@PathVariable Long secteurId) {
        return secteurService.deleteSecteur(secteurId);
    }
}

