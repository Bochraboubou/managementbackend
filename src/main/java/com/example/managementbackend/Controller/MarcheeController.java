package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.MarcheeRepository;
import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.Service.MarcheeService;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Marchee;
import com.example.managementbackend.model.Metier;
import com.example.managementbackend.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class MarcheeController {
    @Autowired
    private MarcheeService marcheeService;


    @GetMapping("/organisations/{organId}/marchees")
    public List<Marchee> getAllMarcheesByOrganId(@PathVariable(value = "organId") Long organId) {
        return marcheeService.getAllMarcheesByOrganId(organId);
    }

    @PostMapping("/organisations/{organId}/marchees/{metierId}")
    public Marchee createMarchee(@PathVariable (value = "organId") Long organId,@PathVariable (value = "metierId") long metierId,
                               @Valid @RequestBody Marchee marchee) {
        return marcheeService.create(organId,metierId,marchee);
    }


    @DeleteMapping("/organisations/{organId}/marchees/{marcheeId}")
    public ResponseEntity<?> deleteMarchee(@PathVariable (value = "organId") Long organId,
                                          @PathVariable (value = "marcheeId") Long marcheeId) {
        return marcheeService.delete(organId,marcheeId);
    }

    @GetMapping("/marcheebycode/{codeMarchee}")
    public Optional<Marchee> getMarcheebyCode(@PathVariable String codeMarchee) {
        return marcheeService.getMarcheebyCode(codeMarchee);
    }
    @GetMapping("/marcheebycode/{codeMarchee}/andOrgan/{organId}")
    public Optional<Marchee> getMarcheebyCodeandOrganId(@PathVariable (value = "codeMarchee") String codeMarchee,@PathVariable (value = "organId") long organId) {
        return marcheeService.getMarcheebyCodeandOrganisation(codeMarchee,organId);
    }

    @GetMapping("/marcheebyMetier/{metierId}/andOrgan/{organId}")
    public Optional<Marchee> getMarcheebyMetierIdandOrganId(@PathVariable (value = "metierId") long metierId,@PathVariable (value = "organId") long organId) {
        return marcheeService.getMarcheebyMetierandOrganisation(metierId,organId);
    }
}






