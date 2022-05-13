package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.MaterielLivreeProService;
import com.example.managementbackend.dto.ArticleDTO;
import com.example.managementbackend.model.ArticleUtilisee;
import com.example.managementbackend.model.MaterielLivreePro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/materielLivreeJoinProjetbyBC/bl/{blId}")
    public List<ArticleDTO> getArticlesRealiseesByBLdeProjet(@PathVariable(value = "blId") long blId){
        return materielLivreeProService.getMaterielLivreeByBL(blId);

    }


}
