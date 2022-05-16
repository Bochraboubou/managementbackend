package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.ArticleRService;
import com.example.managementbackend.dto.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class ArticleRController {
    @Autowired
    private ArticleRService articleRealiseeService;


    @GetMapping("/articlesUtiliseesJoin/{bcId}")
    public List<ArticleDTO> getArticlesUtilisee(@PathVariable long bcId){
        return articleRealiseeService.getArticlesUtilisees(bcId);
    }

    @GetMapping("/articlesJoins")
    public List<ArticleDTO> getArticlesJoins(){
        return articleRealiseeService.getArticlesJoins();
    }


    @GetMapping("/articlesJoinsByMetier/{metierId}")
    public List<ArticleDTO> getArticlesJoinsbyMetier(@PathVariable long metierId){
        return articleRealiseeService.getArticlesJoinsbyMetier(metierId);
    }

    @GetMapping("/articlesRealiseesJoinParPeriode/prestation/{bcId}/{date1}/{date2}")
    public List<ArticleDTO> getArticlesRealiseesPres(@PathVariable(value = "bcId") long bcId, @PathVariable(value = "date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable(value = "date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
        return articleRealiseeService.getArticlesRealiseesPrestationparPeriode(bcId,date1,date2);
    }


    @GetMapping("/articlesRealiseesJoinbydate/prestation/{bcId}/date/{dateA}")
    public List<ArticleDTO> getArticlesRealiseesPresbyDate(@PathVariable(value = "bcId") long bcId, @PathVariable(value = "dateA") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA){
        return articleRealiseeService.getArticlesRealiseesPrestationbyDate(bcId,dateA);
    }

    @GetMapping("/articlesRealiseesJoinGlobalbyBC/prestation/{bcId}")
    public List<ArticleDTO> getArticlesRealiseesPresGlobalby(@PathVariable(value = "bcId") long bcId){
        return articleRealiseeService.getArticlesRealiseesPrestationGlobalbyBC(bcId);
    }

    @GetMapping("/articlesRealiseesJoinParPeriode/MF/{bcId}/{date1}/{date2}")
    public List<ArticleDTO> getArticlesRealiseesMF(@PathVariable(value = "bcId") long bcId, @PathVariable(value = "date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable(value = "date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
        return articleRealiseeService.getArticlesRealiseesMFparPeriode(bcId,date1,date2);
    }


    @GetMapping("/articlesRealiseesJoinbydate/MF/{bcId}/date/{dateA}")
    public List<ArticleDTO> getArticlesRealiseesMFbyDate(@PathVariable(value = "bcId") long bcId, @PathVariable(value = "dateA") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA){
        return articleRealiseeService.getArticlesRealiseesMFbyDate(bcId,dateA);
    }

    @GetMapping("/articlesRealiseesJoinGlobalbyBC/MF/{bcId}")
    public List<ArticleDTO> getArticlesRealiseesMFGlobalby(@PathVariable(value = "bcId") long bcId){
        return articleRealiseeService.getArticlesRealiseesMFGlobalbyBC(bcId);
    }

    @GetMapping("/articlesRealiseesJoinParPeriode/Materiel/{bcId}/{date1}/{date2}")
    public List<ArticleDTO> getArticlesRealiseesMaterielbyPeriode(@PathVariable(value = "bcId") long bcId, @PathVariable(value = "date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable(value = "date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
        return articleRealiseeService.getArticlesRealiseesMaterielparPeriode(bcId,date1,date2);
    }


    @GetMapping("/articlesRealiseesJoinbydate/Materiel/{bcId}/date/{dateA}")
    public List<ArticleDTO> getArticlesRealiseesMaterielbyDate(@PathVariable(value = "bcId") long bcId, @PathVariable(value = "dateA") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA){
        return articleRealiseeService.getArticlesRealiseesMaterielbyDate(bcId,dateA);
    }

    @GetMapping("/articlesRealiseesJoinGlobalbyBC/Materiel/{bcId}")
    public List<ArticleDTO> getArticlesRealiseesMaterielGlobalby(@PathVariable(value = "bcId") long bcId){
        return articleRealiseeService.getArticlesRealiseesMaterielGlobalbyBC(bcId);
    }
}
