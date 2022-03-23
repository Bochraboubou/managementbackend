package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Metier;
import com.example.managementbackend.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class MetierService {
    @Autowired
    private MetierRepository metierRepo;

    @Autowired
    private SecteurRepository secteurRepo;

    public List<Metier> getAllMetiersBySecteurId( Long secteurId) {
        return metierRepo.findBySecteurId(secteurId);
    }

    public List<Metier> getAll() {
        return metierRepo.findAll();
    }

    public Metier create(Long secteurId,Metier metier) {
        return secteurRepo.findById(secteurId).map(secteur -> {
            metier.setSecteur(secteur);
            return metierRepo.save(metier);
        }).orElseThrow(() -> new ResourceNotFoundException("secteurId " + secteurId + " not found"));
    }

    public Optional<Metier> getMetierbyNom(String nomMetier) {
        return metierRepo.findByNomMetier(nomMetier).map(metier -> metierRepo.findByNomMetier(nomMetier)).orElseThrow(() -> new ResourceNotFoundException("nommetier " + nomMetier+ " not found"));
    }

    public Optional<Metier> getMetierbyId(long id) {
        return metierRepo.findById(id).map(metier -> metierRepo.findById(id)).orElseThrow(() -> new ResourceNotFoundException("idmetier " + id+ " not found"));
    }


    public ResponseEntity<?> delete(Long metierId) {

        return metierRepo.findById(metierId).map(metier -> {
            metierRepo.delete(metier);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + metierId + " not found"));
    }

      /*  return metierRepo.findByIdAndSecteurId(metierId, secteurId).map(metier -> {
            metierRepo.delete(metier);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("metier not found with id " + metierId+ " and secteurId " + secteurId));
    }

       */
}
