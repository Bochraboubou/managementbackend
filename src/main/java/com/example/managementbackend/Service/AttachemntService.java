package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.AttachementRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Attachement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class AttachemntService {
    @Autowired
    private AttachementRepository attachementRepo;
@Autowired
    BondeCommandeRepository bondeCommandeRepository;

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

}
