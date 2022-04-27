package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.OrdreDeTraveauxRepository;
import com.example.managementbackend.Service.OrdreDetraveauxService;
import com.example.managementbackend.model.OrdreDeTraveaux;
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
@Autowired
    OrdreDeTraveauxRepository ordreDeTraveauxRepository;

    @GetMapping("/getAllOt")
    public List<OrdreDeTraveaux> getAtt( ){
        return ordreDeTraveauxRepository.findAll();

    }


@GetMapping("OrdreById/{id}")
public Optional<OrdreDeTraveaux> geById(@PathVariable Long id ){
    return ordreService.getOrdreByID(id);

}


    @PostMapping("/bondecommande/{bondeCommandeId}/ordreTraveaux")
    public OrdreDeTraveaux createOrdreTraveaux(@PathVariable(value = "bondeCommandeId") Long bondeCommandeId,
                                         @Valid @RequestBody OrdreDeTraveaux ordreTraveaux) {
        return ordreService.create(bondeCommandeId,ordreTraveaux);
    }

    @GetMapping("/findBYBC/{id}")
    public List<OrdreDeTraveaux>trouverParBCid(@PathVariable Long id ){
        return ordreService.findBYBCid(id);
    }

}
