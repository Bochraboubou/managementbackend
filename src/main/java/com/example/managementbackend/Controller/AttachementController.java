package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.AttachemntService;
import com.example.managementbackend.Service.BondeCommandeService;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.Metier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/attachementsbetween/{date1}/{date2}")
    public List<Attachement> getbetween(@PathVariable(value = "date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable(value = "date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2) {
        return attachementService.getbetween(date1,date2);
    }

}
