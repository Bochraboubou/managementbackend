package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.DemandeRepository;
import com.example.managementbackend.Service.DemandeService;
import com.example.managementbackend.model.Demande;
import com.example.managementbackend.model.Response;
import com.example.managementbackend.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemandeController {
    @Autowired
    DemandeRepository demandeRepository;
    @Autowired
    DemandeService demandeService;






    @PostMapping("/saveDemandefile")
public ResponseEntity<Response> saveDmandeAndImage(@RequestParam("file") MultipartFile file,@RequestParam String  user) throws IOException {
        Demande demande = new ObjectMapper().readValue(user, Demande.class);
        demande.setLogo(file.getBytes());
        demande.setFilename(file.getOriginalFilename());
        Demande dbDemande = demandeService.saveDemande(demande);
        if (dbDemande != null) {
            return new ResponseEntity<>(new Response("demande is successfully saved "), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Response(" demande not saved "), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/demandes")
    public List<Demande> listeDemandes(){
       return demandeService.getDemandes();
    }


    // save
    @PostMapping("/saveDemande")
    public Demande SaveDemande (@RequestBody Demande demande){
        return demandeService.saveDemande(demande);

    }
    // recherche
    @GetMapping("/demande/find/{id}")
    public Demande chercher (@PathVariable("id") Long  id ){
        return demandeService.findDemande(id);

    }
    // DeleteOne
    @DeleteMapping("/deleteDemande/{id}")
    public void DeleteDemande (@PathVariable Long id ){
        demandeService.deleteDemande(id);

    }
    // deleteAll
    @DeleteMapping("/deleteAll")
    public void  DeleteAllDemands (){
        demandeService.deleteALLDemande();

    }
    //Update
    /*
    @PutMapping("/update")
    public Demande UpdateDemande(@RequestBody Demande demande){
      return   demandeService.update(demande);

    }

     */

    //another methode
    @PutMapping("demande/{id}")
    public  void modifier(@PathVariable Long id,@RequestBody Demande demande){
        demandeService.updateDemande(demande ,id);
    }
}
