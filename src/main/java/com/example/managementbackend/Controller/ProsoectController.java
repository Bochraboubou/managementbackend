package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.ProspectRepository;
import com.example.managementbackend.Service.ProspectService;
import com.example.managementbackend.model.Prospect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProsoectController {
    @Autowired
    ProspectRepository prospectRepository;
    @Autowired
    ProspectService prospectService;
    @GetMapping("/findProspect/{email}")
    public Prospect getInformation(@PathVariable String email){

        return prospectRepository.findByEmail(email);
    }
    @PostMapping("/saveprospect")
    public  Prospect save(@RequestBody Prospect prospect){
        return prospectService.saveNewUser(prospect);
    }
    @GetMapping("/allPros")
    public List<Prospect> getAll(){
        return prospectRepository.findAll();
    }


}
