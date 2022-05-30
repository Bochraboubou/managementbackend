package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.DemandeRepository;
import com.example.managementbackend.Service.DemandeService;
import com.example.managementbackend.model.Demande;
import com.example.managementbackend.model.Response;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemandeController {
    @Autowired
    DemandeRepository demandeRepository;
    @Autowired
    DemandeService demandeService;
   @Autowired  ServletContext context ;




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
    @PutMapping("/demande/{id}")
    public  void modifier(@PathVariable Long id, @Valid @RequestBody Demande demande){
        demandeService.updateDemande(demande ,id);
    }


@PostMapping("/demandenew")
public ResponseEntity<Response> savedemande (@RequestParam("file") MultipartFile file,
                                             @RequestParam("demande") String demande) throws JsonParseException, JsonMappingException , Exception
{
    System.out.println("Ok .............");
    Demande demande1 = new ObjectMapper().readValue(demande, Demande.class);
    boolean isExit = new File(context.getRealPath("/Images/")).exists();
    if (!isExit)
    {
        new File (context.getRealPath("/Images/")).mkdir();
        System.out.println("mk dir.............");
    }
    //logo
    String filename = file.getOriginalFilename();
    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
    // document
    String filename1 = file.getOriginalFilename();
    String newFileName1 = FilenameUtils.getBaseName(filename1)+"."+FilenameUtils.getExtension(filename1);




    File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
    File serverFile2= new File (context.getRealPath("/Images/"+File.separator+newFileName1));
    try
    {
        System.out.println("Image");
        FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        FileUtils.writeByteArrayToFile(serverFile2,file.getBytes());

    }catch(Exception e) {
        e.printStackTrace();
    }


    demande1.setFileName(newFileName);
    demande1.setDocumentpath(newFileName1);

    Demande art = demandeService.saveDemande(demande1);
    if (art != null)
    {
        return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
    }
    else
    {
        return new ResponseEntity<Response>(new Response ("Demande not saved"),HttpStatus.BAD_REQUEST);
    }
}

 @GetMapping(path="/Imgdemande/{id}")
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{

        Demande demande  = demandeRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+demande.getFileName()));
    }
    // get document
    @GetMapping(path="/Documentdemande/{id}")
    public byte[] getDocument(@PathVariable("id") Long id) throws Exception{

        Demande demande  = demandeRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+demande.getDocumentpath()));
    }

//get all en attente demande
    @GetMapping(path="/DemandesEnAttente")
    public List<Demande>EnAttenteDemande(){
        return   demandeService.gettAllEnAttenteDemande();

    }
    @GetMapping(path="/DemandesApprouvee")
    public List<Demande>DemandeApprouvee(){
        return   demandeService.gettAllDemandeApprouvé();

    }
}
