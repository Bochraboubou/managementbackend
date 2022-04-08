package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.ArticleRealiseeService;
import com.example.managementbackend.Service.ArticleUtiliseeService;
import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.ArticleUtilisee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/admin")
@RestController
public class ArticleRealiseeController {

    @Autowired
    private ArticleRealiseeService articleRealiseeService;



    @GetMapping("/articlesRealisees")
    public List<ArticleRealisee> getAllArticlesRealisees() {
        return articleRealiseeService.getAll();
    }


    @PostMapping("/attachement/{attachementId}/article/{articleid}/articlerealisee")
    public ArticleRealisee createArticleRealisee(@PathVariable (value = "attachementId") Long attachementId, @PathVariable (value = "articleid") Long articleid,
                                                 @Valid @RequestBody ArticleRealisee articleRealisee) {
        return articleRealiseeService.create(attachementId, articleid, articleRealisee);
    }

}
