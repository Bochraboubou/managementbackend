package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.DemandeRepository;
import com.example.managementbackend.model.Demande;
import com.example.managementbackend.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
    public List<Demande> getDemandes() {
        log.info("getting all demandes  from the data base ");
        return demandeRepository.findAll();
    }
    // Recherche
    public Demande  findDemande(Long  id ) {
        log.info("getting Demande {} from the the data base ", id );
        return demandeRepository.findDemandeById(id);
    }

    // delete une demande
     public void deleteDemande(Long id )
     {demandeRepository.deleteById(id);

     }

    // delete all demandes
    public void deleteALLDemande( )
    {demandeRepository.deleteAll();

    }
    //update
    public void  updateDemande(Demande demande, Long id ){
        Demande demande1=demandeRepository.getById(id);

        demande1.setNom(demande.getNom());
        demande1.setCode(demande.getCode());
        demande1.setAdresse(demande.getAdresse());
        demande1.setEmail(demande.getEmail());
        demande1.setEmailAdmin(demande.getEmailAdmin());
        demande1.setTelOrg(demande.getTelOrg());
        demande1.setTelAdmin(demande.getTelAdmin());
        demande1.setPays(demande.getPays());
        demande1.setEmailDG(demande.getEmailDG());
        demande1.setNomAdmin(demande.getNomAdmin());
        demande1.setNomDG(demande.getNomDG());
        demande1.setTelDG(demande.getTelDG());
        demande1.setSecteur_d_activite(demande.getSecteur_d_activite());
        demande1.setRegion(demande.getRegion());
        demande1.setDocument(demande.getDocument());
        demande1.setLogo(demande.getLogo());
         demandeRepository.save(demande1);
    }
}
