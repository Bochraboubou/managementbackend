package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Service.AttachemntService;
import com.example.managementbackend.Service.BondeCommandeService;

import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.Role;
import com.example.managementbackend.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

import java.util.Optional;

@Slf4j
@RequestMapping("/admin")
@RestController
public class AttachementController {
    @Autowired
    private AttachemntService attachementService;


    // find all

    @GetMapping("/allAttachement")
    public List<Attachement> getAttachementByArticle( ){
        return attachementService. findAllAttachement();
    }


//Nour
    @PostMapping("/addAttachement/{idBC}")
    public Attachement addAttachement(@RequestBody Attachement attachement, @PathVariable Long idBC){
      return  attachementService.saveAttachement(idBC,attachement);
    }
    //nour
@DeleteMapping("/deleteAttachement/{id}")
public void   deleteAttachement( @PathVariable Long id){
   attachementService.DeleteAttachement(id);
}
//nour
@GetMapping("/byCode/{code}")
    public Attachement getAttachementByArticle(@PathVariable  String code ){
        return attachementService.FinAttachementByCode(code);
}


//optionnal
@GetMapping("/byCode2/{code}")
public Optional<Attachement> getAttachementByArticle2(@PathVariable  String code ){
    return Optional.ofNullable(attachementService.FinAttachementByCode(code));
}

    @PostMapping("/bondecommande/{bondeCommandeId}/attachement")
    public Attachement createAttachement(@PathVariable(value = "bondeCommandeId") Long bondeCommandeId,
                                         @Valid @RequestBody Attachement attachement) {
        return attachementService.create(bondeCommandeId,attachement);
    }

    @GetMapping("/attachementsbetween/{date1}/{date2}")
    public List<Attachement> getbetween(@PathVariable(value = "date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable(value = "date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2) {
        return attachementService.getbetween(date1,date2);
    }
    @GetMapping("/findById/{id}")
    public Optional <Attachement>findAttachementById(@PathVariable Long id ) {
        return attachementService.findByID(id);
    }


}
