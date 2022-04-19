package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.dto.BondeCommandeJoin;
import com.example.managementbackend.dto.organisationUserJoin;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Demande;
import com.example.managementbackend.model.Organisation;
import com.example.managementbackend.model.Response;
import com.example.managementbackend.model.Secteur;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.managementbackend.Service.OrganisationService;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class OrganisationController {
    @Autowired
    private OrganisationService organisationService;
    @Autowired
    ServletContext context ;
    @Autowired OrganisationRepository organisationRepository;
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
    @GetMapping("/organisationByNom/{nom}")
    public Optional<Organisation> getOrganisationByNom(@PathVariable String nom) {
        return organisationService.trouverParNom(nom);
    }


    @PostMapping("/NewOrganisation")
    public ResponseEntity<Response> saveOrganisation (@RequestParam("file") MultipartFile file,
                                                 @RequestParam("organisation") String organisation) throws JsonParseException, JsonMappingException, Exception
    {
        System.out.println("Ok .............");
        Organisation organisation1 = new ObjectMapper().readValue(organisation, Organisation.class);

        boolean isExit  = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        organisation1.setFileName(newFileName);
        Organisation art = organisationService.createOrganisation(organisation1);
        if (art != null)
        {
            return new ResponseEntity<Response>(new Response (""), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(new Response ("Organisation not saved"),HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping(path="/ImgOrganisation/{id}")
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{

        Organisation org  = organisationRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+org.getFileName()));
    }

    /*
    @GetMapping("/firstJoinOrganisation")
    public List<organisationUserJoin> firstJOIN() {
        return organisationRepository.getInformations();
    }


    @GetMapping("/getInformationsOrganisation")
    public List<organisationUserJoin> orgJOIN() {
        return organisationRepository.getInformationsOrganisation();
    }



 */














































    //methodes pour l'entreprise

/*    @GetMapping("/organisations/{organId}/entreprises")
    public List<Organisation> getAllEntreprisesByOrganId(@PathVariable(value = "organId") Long organId) {
        return organisationRepo.findBySuporganId(organId);
*/




  





}
