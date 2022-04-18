package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.AttachemntService;
import com.example.managementbackend.Service.OrdreDefinitifService;
import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.OrdreDefinitif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class OrdreDefinitifController {
    @Autowired
    private OrdreDefinitifService ordreDefinitifService;

//jhjhj
    @PostMapping("/ordreTraveaux/{ordreTraveauxId}/article/{articleid}/ordreDefintif")
    public OrdreDefinitif createOrdreDefinitif(@PathVariable(value = "ordreTraveauxId") Long ordreTraveauxId, @PathVariable (value = "articleid") Long articleid,
                                               @Valid @RequestBody OrdreDefinitif ordreDefinitif) {
        return ordreDefinitifService.create(ordreTraveauxId, articleid,ordreDefinitif );
    }
}
