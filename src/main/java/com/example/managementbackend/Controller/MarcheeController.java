package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.MarcheeRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Marchee;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class MarcheeController {
    @Autowired
    private MarcheeRepository marcheeRepo;

    @Autowired
    private OrganisationRepository organRepo;

    @GetMapping("/organisations/{organId}/marchees")
    public List<Marchee> getAllMarcheesByOrganId(@PathVariable(value = "organId") Long organId) {
        return marcheeRepo.findByOrgId(organId);
    }

    @PostMapping("/organisations/{organId}/marchees")
    public Marchee createMarchee(@PathVariable (value = "organId") Long organId,
                               @Valid @RequestBody Marchee marchee) {
        return organRepo.findById(organId).map(organisation -> {
            marchee.setOrg(organisation);
            return marcheeRepo.save(marchee);
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
    }


    @DeleteMapping("/organisations/{organId}/marchees/{marcheeId}")
    public ResponseEntity<?> deleteMarchee(@PathVariable (value = "organId") Long organId,
                                          @PathVariable (value = "marcheeId") Long marcheeId) {
        return marcheeRepo.findByIdAndOrgId(marcheeId, organId).map(marchee -> {
            marcheeRepo.delete(marchee);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("marchee not found with id " + marcheeId+ " and organisationId " + organId));
    }
}






