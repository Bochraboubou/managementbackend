package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.OrganisationRepository;

import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Organisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
@Service
public class OrganisationService {
    @Autowired
    private OrganisationRepository organisationRepo;
    @Autowired
    SecteurRepository secteurRepo;

    public List<Organisation> getAll() {
        return organisationRepo.findAll();
    }

    public Optional<Organisation> getOrganById(Long organId) {
        return organisationRepo.findById(organId).map(organisation ->
                organisationRepo.findById(organId)).
                orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }

   public Optional<Organisation> getByCode(String codeOrgan) {
        return organisationRepo.findByCode(codeOrgan).map(organisation ->
                organisationRepo.findByCode(codeOrgan)).orElseThrow(() ->
                new ResourceNotFoundException("codeOrgan " + codeOrgan + " not found"));
    }



    public Optional<Organisation> getOrganisationByCode(String codeOrgan) {
        return organisationRepo.findByCode(codeOrgan);
    }




    public Optional<Organisation> getByBonDeCommande(long bonDeCommandeId) {
        return organisationRepo.findByBonDeCommandesId(bonDeCommandeId).map(organisation -> organisationRepo.findByBonDeCommandesId(bonDeCommandeId)).orElseThrow(() -> new ResourceNotFoundException("bonDeCommandeId " + bonDeCommandeId+ " not found"));
    }






    public Organisation createOrganisation(Organisation organisation) {
        MultipartFile file = null;
        return organisationRepo.save(organisation);
    }

    public Organisation updateOrganisation(Long organId, Organisation organisationRequest) {
        return organisationRepo.findById(organId).map(organisation -> {
            organisation.setNom(organisationRequest.getNom());

            //ona a pas le droit de changer le code de confirmation donner par le" cpm"
            //organisation.setCode_confirmation(organisationRequest.getCode_confirmation());

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

            organisation.setUsers(organisationRequest.getUsers());

            organisation.setNomAdmin(organisationRequest.getNomAdmin());
            organisation.setTelAdmin(organisationRequest.getTelAdmin());
            organisation.setEmailAdmin(organisationRequest.getEmailAdmin());



            return organisationRepo.save(organisation);
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }


    public ResponseEntity<?> deleteOrganisation(Long organId) {
        return organisationRepo.findById(organId).map(organisation -> {
            organisationRepo.delete(organisation);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }





    public Optional<Organisation> getOrganisationByUser(long idUser) {
        return organisationRepo.findByUsersId(idUser).map(organisation
                -> organisationRepo.findByUsersId(idUser)).orElseThrow(()
                -> new ResourceNotFoundException("idUser " + idUser+ " not found"));
    }



    public Optional<Organisation>trouverParNom(String nom)
    {return organisationRepo.findByNom(nom);

    }


    public Optional<Organisation> getByUserName(String userName) {
        return organisationRepo.findByUsersUsername(userName).map(organisation -> organisationRepo.findByUsersUsername(userName)).orElseThrow(() -> new ResourceNotFoundException("userName " + userName+ " not found"));
    }




    }



