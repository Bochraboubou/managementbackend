package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.AttachemntService;
import com.example.managementbackend.Service.OrdreDetraveauxService;
import com.example.managementbackend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class OrdreDeTraveauxController {
    @Autowired
    private OrdreDetraveauxService ordreService;

    @GetMapping("/ordresDeTraveaux")
    public List<OrdreDeTraveaux> getAllOTs() {
        return ordreService.getAll();
    }

    @PostMapping("/bondecommande/{bondeCommandeId}/ordreTraveaux")
    public OrdreDeTraveaux createOrdreTraveaux(@PathVariable(value = "bondeCommandeId") Long bondeCommandeId,
                                         @Valid @RequestBody OrdreDeTraveaux ordreTraveaux) {
        return ordreService.create(bondeCommandeId,ordreTraveaux);
    }

    @GetMapping("/montantTotalOT")
    public float getTotalMontantOT() {
        return ordreService.geMontantTotalOT();
    }
}
