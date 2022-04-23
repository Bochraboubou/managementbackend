package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.AttachemntService;
import com.example.managementbackend.Service.OrdreDetraveauxService;
import com.example.managementbackend.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/bondeCommande/{bcId}/montantTotalOT")
    public float getTotalMontantOT(@PathVariable(value = "bcId") long bcId) {
        return ordreService.geMontantTotalOT(bcId);
    }

    @GetMapping("/OT/codeOT/{codeOT}/bcId/{bcId}")
    public Optional<OrdreDeTraveaux> getByCodeandBCId(@PathVariable(value = "codeOT") String codeOT, @PathVariable(value = "bcId") Long bcId) {
        return ordreService.getOTByCodeandBCId(codeOT,bcId);
    }


    @GetMapping("/bc/{bcId}/ots")
    public List<OrdreDeTraveaux> getAllOTBybcID(@PathVariable(value = "bcId") Long bcId) {
        return ordreService.getAllBYBC(bcId);
    }
}
