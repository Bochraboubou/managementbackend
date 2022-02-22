package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class OrganisationController {
    @Autowired
    private OrganisationRepository organisationRepo;

    @GetMapping("/organisations")
    public List<Organisation> getAll() {
        return organisationRepo.findAll();
    }

    @PostMapping("/organisations")
    public Organisation createOrganisation(@Valid @RequestBody Organisation organisation) {
        return organisationRepo.save(organisation);
    }

    @PutMapping("/organisations/{organId}")
    public Organisation updateOrganisation(@PathVariable Long organId, @Valid @RequestBody Organisation organisationRequest) {
        return organisationRepo.findById(organId).map(organisation -> {
            organisation.setNom(organisationRequest.getNom());
            organisation.setCode(organisationRequest.getCode());
            organisation.setSecteur_d_activité(organisationRequest.getSecteur_d_activité());
            organisation.setEmail(organisationRequest.getEmail());
            organisation.setPays(organisationRequest.getPays());
            organisation.setRegion(organisationRequest.getRegion());
            organisation.setAdresse(organisationRequest.getAdresse());
            organisation.setTel(organisationRequest.getTel());
            organisation.setType(organisationRequest.getType());
            organisation.setNomDG(organisationRequest.getNomDG());
            organisation.setTelDG(organisationRequest.getTelDG());
            organisation.setEmailDG(organisationRequest.getEmailDG());
            organisation.setNomAdmin(organisationRequest.getNomAdmin());
            organisation.setTelAdmin(organisationRequest.getTelAdmin());
            organisation.setEmailAdmin(organisationRequest.getEmailAdmin());



            return organisationRepo.save(organisation);
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }


    @DeleteMapping("/organisations/{organId}")
    public ResponseEntity<?> deletePost(@PathVariable Long organId) {
        return organisationRepo.findById(organId).map(organisation -> {
            organisationRepo.delete(organisation);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }
}
