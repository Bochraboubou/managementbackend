package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.AttachementMCService;
import com.example.managementbackend.Service.AttachemntService;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.AttachementMC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/admin")
@RestController
public class AttachementMCController {
    @Autowired
    private AttachementMCService attachementMCService;

    @PostMapping("/ordreTraveaux/{ordreTraveauxId}/attachementMC")
    public AttachementMC createAttachementMC(@PathVariable(value = "ordreTraveauxId") Long ordreTraveauxId,
                                             @Valid @RequestBody AttachementMC attachementMC) {
        return attachementMCService.create(ordreTraveauxId,attachementMC);
    }
}
