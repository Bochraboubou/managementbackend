package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.dto.BondeCommandeJoin;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Organisation;
import com.example.managementbackend.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.managementbackend.Service.OrganisationService;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;
    @GetMapping("/organisationByNom/{nom}")
    public Optional<Organisation> getOrganisationByNom(@PathVariable String nom) {
        return organisationService.trouverParNom(nom);
    }
    @GetMapping("/organisations")
    public List<Organisation> getAll() {
        return organisationService.getAll();
    }

    @GetMapping("/oneorganisations/{organId}")
    public Optional<Organisation> getOrganById(@PathVariable Long organId) {
        return organisationService.getOrganById(organId);
    }



    @GetMapping("/organisationbyBonDeCommande/{bonDeCommandeId}")
    public Optional<Organisation> getOrganByBonDeCommandeId(@PathVariable long bonDeCommandeId) {
        return organisationService.getByBonDeCommande(bonDeCommandeId);
    }

    @PostMapping("/organisations")
    public Organisation createOrganisation(@Valid @RequestBody Organisation organisation) {
        return organisationService.createOrganisation(organisation);
    }

    @PutMapping("/organisations/{organId}")
    public Organisation updateOrganisation(@PathVariable Long organId, @Valid @RequestBody Organisation organisationRequest) {
        return organisationService.updateOrganisation(organId,organisationRequest);
    }
    @DeleteMapping("/organisations/{organId}")
    public ResponseEntity<?> deleteOrganisation(@PathVariable Long organId) {
       return organisationService.deleteOrganisation(organId);
    }





    @GetMapping("/organisationbyCode/{codeOrgan}")
    public Optional<Organisation> getOrganByCode(@PathVariable String codeOrgan) {
        return organisationService.getByCode(codeOrgan);
    }


    @GetMapping("/orgbyCode/{codeOrgan}")
    public Optional<Organisation> getOrganByCodeNOUR(@PathVariable String codeOrgan) {
        return organisationService.getOrganisationByCode(codeOrgan);
    }


    @GetMapping("/organisationByUser/{idUser}")
    public Optional<Organisation> getOrganisationUser(@PathVariable long idUser) {
        return organisationService.getOrganisationByUser(idUser);
    }
    @GetMapping("/organisationbyUserName/{userName}")
    public Optional<Organisation> getOrganByUserName(@PathVariable String userName) {
        return organisationService.getByUserName(userName);

    }




    //methodes pour l'entreprise

/*    @GetMapping("/organisations/{organId}/entreprises")
    public List<Organisation> getAllEntreprisesByOrganId(@PathVariable(value = "organId") Long organId) {
        return organisationRepo.findBySuporganId(organId);
*/


}
