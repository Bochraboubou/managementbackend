package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.ProspectRepository;
import com.example.managementbackend.model.Prospect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProsoectController {
    @Autowired
    ProspectRepository prospectRepository;
    @GetMapping("/findProspect/{email}")
    public Prospect getInformation(@PathVariable String email){
        return prospectRepository.findByEmail(email);
    }


}
