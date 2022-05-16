package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.ArticleRealiseeMCService;
import com.example.managementbackend.dto.ArticleDTO;
import com.example.managementbackend.model.ArticleRealiseeMC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
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
        return articleRealiseeMCService.ListRealiseeMCByAttaID(id);}

    @GetMapping("/articlesRealiseesJoinParPeriode/prestation/ot/{otId}/{date1}/{date2}")
    public List<ArticleDTO> getArticlesRealiseesPresbyOT(@PathVariable(value = "otId") long otId, @PathVariable(value = "date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable(value = "date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
        return articleRealiseeMCService.getArticlesRealiseesPrestationparPeriodeByOT(otId,date1,date2);
    }


    @GetMapping("/articlesRealiseesJoinbydate/prestation/ot/{otId}/date/{dateA}")
    public List<ArticleDTO> getArticlesRealiseesPresbyDatebyOT(@PathVariable(value = "otId") long otId, @PathVariable(value = "dateA") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA){
        return articleRealiseeMCService.getArticlesRealiseesPrestationbyDateByOT(otId,dateA);
    }

    @GetMapping("/articlesRealiseesJoinGlobalbyBC/prestation/ot/{otId}")
    public List<ArticleDTO> getArticlesRealiseesPresGlobalbyOT(@PathVariable(value = "otId") long otId){
        return articleRealiseeMCService.getArticlesRealiseesPrestationGlobalByOT(otId);
    }

    @GetMapping("/articlesRealiseesJoinParPeriode/MF/ot/{otId}/{date1}/{date2}")
    public List<ArticleDTO> getArticlesRealiseesMFbyOT(@PathVariable(value = "otId") long otId, @PathVariable(value = "date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable(value = "date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
        return articleRealiseeMCService.getArticlesRealiseesMFparPeriodeByOT(otId,date1,date2);
    }


    @GetMapping("/articlesRealiseesJoinbydate/MF/ot/{otId}/date/{dateA}")
    public List<ArticleDTO> getArticlesRealiseesMFbyDatebyOT(@PathVariable(value = "otId") long otId, @PathVariable(value = "dateA") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA){
        return articleRealiseeMCService.getArticlesRealiseesMFbyDateByOT(otId,dateA);
    }

    @GetMapping("/articlesRealiseesJoinGlobalbyBC/MF/ot/{otId}")
    public List<ArticleDTO> getArticlesRealiseesMFGlobalbyOT(@PathVariable(value = "otId") long otId){
        return articleRealiseeMCService.getArticlesRealiseesMFGlobalByOT(otId);
    }

    @GetMapping("/articlesRealiseesJoinParPeriode/materiel/ot/{otId}/{date1}/{date2}")
    public List<ArticleDTO> getArticlesRealiseesMaterielbyOT(@PathVariable(value = "otId") long otId, @PathVariable(value = "date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable(value = "date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
        return articleRealiseeMCService.getArticlesRealiseesMaterielparPeriodeByOT(otId,date1,date2);
    }


    @GetMapping("/articlesRealiseesJoinbydate/materiel/ot/{otId}/date/{dateA}")
    public List<ArticleDTO> getArticlesRealiseesMaterielbyDatebyOT(@PathVariable(value = "otId") long otId, @PathVariable(value = "dateA") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA){
        return articleRealiseeMCService.getArticlesRealiseesMaterielbyDateByOT(otId,dateA);
    }

    @GetMapping("/articlesRealiseesJoinGlobalbyBC/materiel/ot/{otId}")
    public List<ArticleDTO> getArticlesRealiseesMaterielGlobalbyOT(@PathVariable(value = "otId") long otId){
        return articleRealiseeMCService.getArticlesRealiseesMaterielGlobalByOT(otId);
    }
}
