package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.MaterielLivreeProService;
import com.example.managementbackend.model.ArticleUtilisee;
import com.example.managementbackend.model.MaterielLivreePro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class MterielLivreeProController {
    @Autowired
    MaterielLivreeProService materielLivreeProService;


    @PostMapping("/bondesLivraison/{blid}/article/{articleid}/MaterielLivree")
    public MaterielLivreePro createArticleUtilisee(@PathVariable(value = "blid") Long blid, @PathVariable (value = "articleid") Long articleid,
                                                 @Valid @RequestBody MaterielLivreePro materielLivree) {
        return materielLivreeProService.create(blid, articleid, materielLivree);
    }


}
