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

import java.util.Optional;

@Slf4j
@RequestMapping("/admin")
@RestController
public class AttachementController {
    @Autowired
    private AttachemntService attachementService;

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

}
