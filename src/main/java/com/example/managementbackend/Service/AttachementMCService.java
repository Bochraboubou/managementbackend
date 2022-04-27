package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.AttachementMCRepository;
import com.example.managementbackend.Repository.AttachementRepository;
import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.OrdreDeTraveauxRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.AttachementMC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class AttachementMCService {
    @Autowired
    private AttachementMCRepository attachementMCRepo;

    @Autowired
    private OrdreDeTraveauxRepository ordreTraveauxRepo;




    public List<AttachementMC> getAll(){
        return   attachementMCRepo.findAll();
    }
    public AttachementMC getByCode(String code ){
        return  attachementMCRepo.findBycodeAttachementMC(code);
    }

    public AttachementMC create(Long ordreTraveauxId, AttachementMC attachementMC) {
        return ordreTraveauxRepo.findById(ordreTraveauxId).map(ordreTraveaux -> {
            attachementMC.setOrdreTraveaux(ordreTraveaux);
            return attachementMCRepo.save(attachementMC);
        }).orElseThrow(() -> new ResourceNotFoundException("ordreTravaeauxId " + ordreTraveauxId+ " not found"));
    }


}
