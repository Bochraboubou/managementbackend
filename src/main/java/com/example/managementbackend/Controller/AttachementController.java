package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.AttachemntService;
import com.example.managementbackend.Service.BondeCommandeService;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/admin")
@RestController
public class AttachementController {
    @Autowired
    private AttachemntService attachementService;

    @PostMapping("/bondecommande/{bondeCommandeId}/attachement")
    public Attachement createAttachement(@PathVariable(value = "bondeCommandeId") Long bondeCommandeId,
                                         @Valid @RequestBody Attachement attachement) {
        return attachementService.create(bondeCommandeId,attachement);
    }

}
