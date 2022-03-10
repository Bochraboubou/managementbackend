package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@Service
public class OrganisationService {
    @Autowired
    private OrganisationRepository organisationRepo;

    public List<Organisation> getAll() {
        return organisationRepo.findAll();
    }

    public Optional<Organisation> getOrganById(Long organId) {
        return organisationRepo.findById(organId).map(organisation -> organisationRepo.findById(organId)).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }

    public Optional<Organisation> getByCode(String codeOrgan) {
        return organisationRepo.findByCode(codeOrgan).map(organisation -> organisationRepo.findByCode(codeOrgan)).orElseThrow(() -> new ResourceNotFoundException("codeOrgan " + codeOrgan + " not found"));
    }

    public Organisation createOrganisation(Organisation organisation) {
        return organisationRepo.save(organisation);
    }

    public Organisation updateOrganisation(Long organId,Organisation organisationRequest) {
        return organisationRepo.findById(organId).map(organisation -> {
            organisation.setNom(organisationRequest.getNom());
            organisation.setCode(organisationRequest.getCode());
            organisation.setSecteur_d_activite(organisationRequest.getSecteur_d_activite());
            organisation.setEmail(organisationRequest.getEmail());
            organisation.setPays(organisationRequest.getPays());
            organisation.setRegion(organisationRequest.getRegion());
            organisation.setAdresse(organisationRequest.getAdresse());
            organisation.setTel(organisationRequest.getTel());
            organisation.setType(organisationRequest.getType());
            organisation.setNomDG(organisationRequest.getNomDG());
            organisation.setTelDG(organisationRequest.getTelDG());
            organisation.setEmailDG(organisationRequest.getEmailDG());


            return organisationRepo.save(organisation);
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }


    @DeleteMapping("/organisations/{organId}")
    public ResponseEntity<?> deleteOrganisation(Long organId) {
        return organisationRepo.findById(organId).map(organisation -> {
            organisationRepo.delete(organisation);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }
}
