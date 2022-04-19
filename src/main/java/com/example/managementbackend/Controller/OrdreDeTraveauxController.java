package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.AttachemntService;
import com.example.managementbackend.Service.OrdreDetraveauxService;
import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.OrdreDeTraveaux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class OrdreDeTraveauxController {
    @Autowired
    private OrdreDetraveauxService ordreService;



    @PostMapping("/bondecommande/{bondeCommandeId}/ordreTraveaux")
    public OrdreDeTraveaux createOrdreTraveaux(@PathVariable(value = "bondeCommandeId") Long bondeCommandeId,
                                         @Valid @RequestBody OrdreDeTraveaux ordreTraveaux) {
        return ordreService.create(bondeCommandeId,ordreTraveaux);
    }
}
