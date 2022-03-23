package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.Service.MetierService;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Metier;
import com.example.managementbackend.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class MetierController {
    @Autowired
    private MetierService metierService;


    @GetMapping("/secteurs/{secteurId}/metiers")
    public List<Metier> getAllMetiersBySecteurId(@PathVariable(value = "secteurId") Long secteurId) {
        return metierService.getAllMetiersBySecteurId(secteurId);
    }
    @GetMapping("/secteurs/metiers")
    public List<Metier> getAllMetiers() {
        return metierService.getAll();
    }

    @GetMapping("/metierbynom/{nomMetier}")
    public Optional<Metier> getMetierbyNom(@PathVariable String nomMetier) {
        return metierService.getMetierbyNom(nomMetier);
    }


    @GetMapping("/metierbyid/{id}")
    public Optional<Metier> getMetierbyId(@PathVariable long id) {
        return metierService.getMetierbyId(id);
    }

    @PostMapping("/secteurs/{secteurId}/metiers")
    public Metier createMetier(@PathVariable (value = "secteurId") Long secteurId,
                                       @Valid @RequestBody Metier metier) {
        return metierService.create(secteurId,metier);
    }


    @DeleteMapping("/metiers/{metierId}")
    public ResponseEntity<?> deleteMetier(@PathVariable (value = "metierId") Long metierId) {

        return metierService.delete(metierId);
    }

      /*  return metierRepo.findByIdAndSecteurId(metierId, secteurId).map(metier -> {
            metierRepo.delete(metier);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("metier not found with id " + metierId+ " and secteurId " + secteurId));
    }

       */
}




