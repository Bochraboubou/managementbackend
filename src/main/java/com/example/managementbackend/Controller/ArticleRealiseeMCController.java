package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.ArticleRealiseeMCService;
import com.example.managementbackend.Service.ArticleRealiseeService;
import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.ArticleRealiseeMC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class ArticleRealiseeMCController {

    @Autowired
    private ArticleRealiseeMCService articleRealiseeMCService;



    @GetMapping("/articlesRealiseesMC")
    public List<ArticleRealiseeMC> getAllArticlesRealiseesMC() {
        return articleRealiseeMCService.getAll();
    }


    @PostMapping("/attachementMC/{attachemenMCId}/article/{articleid}/articlerealiseeMC")
    public ArticleRealiseeMC createArticleRealiseeMC(@PathVariable(value = "attachemenMCId") Long attachementMCId, @PathVariable (value = "articleid") Long articleid,
                                                 @Valid @RequestBody ArticleRealiseeMC articleRealiseeMC) {
        return articleRealiseeMCService.create(attachementMCId, articleid, articleRealiseeMC);
    }

    // get liste of article realisee in one MC by attachement id
    @GetMapping("/getARmcByAttachementId/{id}")
    public  List<ArticleRealiseeMC>ARmcByAttachementId(@PathVariable Long id ){
        return articleRealiseeMCService.ListRealiseeMCByAttaID(id);
    }
}
