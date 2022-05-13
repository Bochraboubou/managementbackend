package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.BondeCommandeRepository;
import com.example.managementbackend.Repository.MarcheeRepository;
import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.dto.BondeCommandeDTO;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.BondeCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BondeCommandeService {
    @Autowired
    private BondeCommandeRepository bcRepo;

    @Autowired
    private MarcheeRepository marcheeRepo;

    @Autowired
    private OrganisationRepository organisationRepo;

    public List<BondeCommandeDTO> getAllBondeCommandesJoin(long marcheeId){
        return bcRepo.getAllBondesCommandesJoin(marcheeId);
    }


    public Optional<BondeCommandeDTO> getBondeCommandesJoin(long bcId){
        return bcRepo.getBondesCommandesJoin(bcId).map(bondeCommandeJoin -> bcRepo.getBondesCommandesJoin(bcId)).orElseThrow(() -> new ResourceNotFoundException("bonDeCommandeId " + bcId+ " not found"));
    }

    public List<BondeCommande> getAllbcsBymarcheeId(Long marcheeId) {
        return bcRepo.findByMarcheeId(marcheeId);
    }

    public List<BondeCommande> getAll() {
        return bcRepo.findAll();
    }

    public Optional<BondeCommande> getBCbyCode(String code) {
        return bcRepo.findByCodebc(code).map(bondeCommande -> bcRepo.findByCodebc(code)).orElseThrow(() -> new ResourceNotFoundException("code " + code+ " not found"));
    }


    public Optional<BondeCommande> getBCbyId(long id) {
        return bcRepo.findById(id).map(bondeCommande -> bcRepo.findById(id)).orElseThrow(() -> new ResourceNotFoundException("idBC " + id+ " not found"));
    }

    public BondeCommande create(Long marcheeId,Long entrepId, BondeCommande bondecommande) {
        return marcheeRepo.findById(marcheeId).map(marchee -> {
            bondecommande.setMarchee(marchee);
            return organisationRepo.findById(entrepId).map(entreprise -> {
                bondecommande.setEntreprise(entreprise);
                return bcRepo.save(bondecommande);
            }).orElseThrow(() -> new ResourceNotFoundException("entrepriseId " + entrepId + " not found"));


        }).orElseThrow(() -> new ResourceNotFoundException("marcheeId " + marcheeId + " not found"));
    }


    public ResponseEntity<?> delete(Long marcheeId, Long bcId) {
        return  bcRepo.findByIdAndMarcheeId(bcId, marcheeId).map(bondecommande -> {
            bcRepo.delete(bondecommande);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("bonde commande not found with id " + bcId+ " and marcheeId " + marcheeId));
    }

}
