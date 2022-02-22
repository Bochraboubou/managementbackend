package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.EntrepriseRepository;
import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class EntrepriseController {
    @Autowired
    private EntrepriseRepository entrepriseRepo;

    @Autowired
    private OrganisationRepository organisationRepo;

    @GetMapping("/organisations/{organId}/entreprises")
    public Page<Entreprise> getAllEntreprisesByOrganId(@PathVariable(value = "organId") Long organId,
                                                       Pageable pageable) {
        return entrepriseRepo.findByOrganisationId(organId, pageable);
    }

    @PostMapping("/organisations/{organId}/entreprises")
    public Entreprise createEntreprise(@PathVariable (value = "organId") Long organId,
                                 @Valid @RequestBody Entreprise entreprise) {
        return organisationRepo.findById(organId).map(organisation -> {
            entreprise.setOrganisation(organisation);
            return entrepriseRepo.save(entreprise);
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }

    @PutMapping("/organisations/{organId}/entreprises/{entrepId}")
    public Entreprise updateEntreprise(@PathVariable (value = "organId") Long organId,
                                 @PathVariable (value = "entrepId") Long entrepId,
                                 @Valid @RequestBody Entreprise entrepriseRequest) {
        if(!organisationRepo.existsById(organId)) {
            throw new ResourceNotFoundException("organId " + organId + " not found");
        }

        return entrepriseRepo.findById(organId).map(entreprise -> {
            entreprise.setNom(entrepriseRequest.getNom());
            entreprise.setCode(entrepriseRequest.getCode());
            entreprise.setSecteur_d_activité(entrepriseRequest.getSecteur_d_activité());
            entreprise.setEmail(entrepriseRequest.getEmail());
            entreprise.setPays(entrepriseRequest.getPays());
            entreprise.setRegion(entrepriseRequest.getRegion());
            entreprise.setAdresse(entrepriseRequest.getAdresse());
            entreprise.setTel(entrepriseRequest.getTel());
            entreprise.setType(entrepriseRequest.getType());
            entreprise.setNomDG(entrepriseRequest.getNomDG());
            entreprise.setTelDG(entrepriseRequest.getTelDG());
            entreprise.setEmailDG(entrepriseRequest.getEmailDG());
            entreprise.setNomAdmin(entrepriseRequest.getNomAdmin());
            entreprise.setTelAdmin(entrepriseRequest.getTelAdmin());
            entreprise.setEmailAdmin(entrepriseRequest.getEmailAdmin());

            return entrepriseRepo.save(entreprise);
        }).orElseThrow(() -> new ResourceNotFoundException("entrepriseId " + entrepId+ "not found"));
    }

    @DeleteMapping("/organisations/{organId}/entreprises/{entrepId}")
    public ResponseEntity<?> deleteEntreprise(@PathVariable (value = "organId") Long organId,
                                           @PathVariable (value = "entrepId") Long entrepId) {
        return entrepriseRepo.findByIdAndOrganisationId(entrepId, organId).map(entreprise -> {
            entrepriseRepo.delete(entreprise);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("entreprise not found with id " + entrepId+ " and organisationId " + organId));
    }
}

