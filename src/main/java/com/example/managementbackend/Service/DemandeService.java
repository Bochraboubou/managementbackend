package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.DemandeRepository;
import com.example.managementbackend.model.Demande;
import com.example.managementbackend.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DemandeService {

    @Autowired
    DemandeRepository demandeRepository;
    //save
    public Demande  saveDemande (Demande d ) {
        log.info("saving user  {}to the data base ", d.getNom());
        return  demandeRepository.save(d);
    }
    //getAll
    public List<Demande> getUsers() {
        log.info("getting all demandes  from the data base ");
        return demandeRepository.findAll();
    }
    // get one demande
    public Demande  getDemande(Long  id ) {
        log.info("getting Demande {} from the the data base ", id );
        return demandeRepository.findDemandeById(id);
    }

    // delete une demande
     public void deleteDemande(Long id )
     {demandeRepository.deleteById(id);

     }

    // delete all demandes
    public void deleteALLDemande(Long id )
    {demandeRepository.deleteAll();

    }
}
