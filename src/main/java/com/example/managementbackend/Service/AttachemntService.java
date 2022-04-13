package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.AttachementRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttachemntService {
    @Autowired
    private AttachementRepository attachementRepo;

    @Autowired
    private BondeCommandeRepository bondeCommandeRepo;

    public Attachement create(Long bondeCommandeId, Attachement attachement) {
        return bondeCommandeRepo.findById(bondeCommandeId).map(bondeCommande -> {
            attachement.setBonDeCommande(bondeCommande);
            return attachementRepo.save(attachement);
        }).orElseThrow(() -> new ResourceNotFoundException("bondeCommandeId " + bondeCommandeId+ " not found"));
    }

    public List<Attachement> getbetween(@DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date2) {
        return attachementRepo.getbetweendate(date1,date2);
    }
}
