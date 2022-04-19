package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.AttachementRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Attachement;

import lombok.extern.slf4j.Slf4j;

import com.example.managementbackend.model.Metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;




import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AttachemntService {
    @Autowired
    private AttachementRepository attachementRepo;

    @Autowired
    private BondeCommandeRepository bondeCommandeRepo;

    @Autowired
    BondeCommandeRepository bondeCommandeRepository;



// find all
public List <Attachement>findAllAttachement( ){
    return attachementRepo.findAll();

}

 public Optional <Attachement>findByID( Long id ){
     return attachementRepo.findById(id);

}
    public Attachement ajouterAttachement( Attachement attachement){
        return attachementRepo.save(attachement);
    }


    public Attachement saveAttachement(Long Bcid, Attachement attachement) {

        log.info("saving attachement  {}to the data base ", attachement.getCodeAttachement());
        return bondeCommandeRepository.findById(Bcid).map(bondeCommande -> {


            attachement.setBonDeCommande(bondeCommande);


            return attachementRepo.save(attachement);
        }).orElseThrow(() -> new ResourceNotFoundException("bondde commande  " + Bcid + " not found"));

}
public void DeleteAttachement(Long id ){
        attachementRepo.deleteById(id);


}
//find attachement by code
    public Attachement FinAttachementByCode(String code){
      return   attachementRepo.findByCodeAttachement(code);
    }





    public Attachement create(Long bondeCommandeId, Attachement attachement) {
        return bondeCommandeRepo.findById(bondeCommandeId).map(bondeCommande -> {
            attachement.setBonDeCommande(bondeCommande);
            return attachementRepo.save(attachement);
        }).orElseThrow(() -> new ResourceNotFoundException("bondeCommandeId " + bondeCommandeId+ " not found"));
    }

    public List<Attachement> getbetween(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date2) {
        return attachementRepo.getbetweendate(date1,date2);
    }

}
