package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Service
public class SecteurService {
    @Autowired
    private SecteurRepository secteurRepo;

    public List<Secteur> getAll() {
        return secteurRepo.findAll();
    }


    public Optional<Secteur> getSecteurbyNom(String nomSecteur) {
        return secteurRepo.findByNomSecteur(nomSecteur).map(secteur -> secteurRepo.findByNomSecteur(nomSecteur)).orElseThrow(() -> new ResourceNotFoundException("nomSecteur " + nomSecteur+ " not found"));
    }

    public Optional<Secteur> getSecteurbyId(long idSecteur) {
        return secteurRepo.findById(idSecteur).map(secteur -> secteurRepo.findById(idSecteur)).orElseThrow(() -> new ResourceNotFoundException("idSecteur " + idSecteur+ " not found"));
    }

    public Optional<Secteur> getSecteurbymetiers(long idmetier) {
        return secteurRepo.findByMetiersId(idmetier).map(secteur
                -> secteurRepo.findByMetiersId(idmetier)).orElseThrow(()
                -> new ResourceNotFoundException("idmetier " + idmetier+ " not found"));
    }

    public Secteur createSecteur(Secteur secteur) {
        return secteurRepo.save(secteur);
    }


    public Secteur updateSecteur(Long secteurId,Secteur secteurRequest) {
        return secteurRepo.findById(secteurId).map(secteur -> {
            secteur.setNomSecteur(secteurRequest.getNomSecteur());

            return secteurRepo.save(secteur);
        }).orElseThrow(() -> new ResourceNotFoundException("secteurId " + secteurId + " not found"));
    }



    public ResponseEntity<?> deleteSecteur(Long secteurId) {
        return secteurRepo.findById(secteurId).map(secteur -> {
            secteurRepo.delete(secteur);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + secteurId + " not found"));
    }
    public List<Object>  SecteurAndMetier(){
        return secteurRepo.getSecteurByMetier();

    }
}
