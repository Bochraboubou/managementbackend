package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.ArticleRService;
import com.example.managementbackend.Service.ArticleService;
import com.example.managementbackend.dto.ArticleR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class ArticleRController {
    @Autowired
    private ArticleRService articleRealiseeService;


    @GetMapping("/articlesUtiliseesJoin/{bcId}")
    public List<ArticleR> getArticlesUtilisee(@PathVariable long bcId){
        return articleRealiseeService.getArticlesUtilisees(bcId);
    }

    @GetMapping("/articlesJoins")
    public List<ArticleR> getArticlesJoins(){
        return articleRealiseeService.getArticlesJoins();
    }


    @GetMapping("/articlesJoinsByMetier/{metierId}")
    public List<ArticleR> getArticlesJoinsbyMetier(@PathVariable long metierId){
        return articleRealiseeService.getArticlesJoinsbyMetier(metierId);
    }

    @GetMapping("/articlesRealiseesJoinParPeriode/{bcId}/{date1}/{date2}")
    public List<ArticleR> getArticlesRealisees(@PathVariable(value = "bcId") long bcId, @PathVariable(value = "date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @PathVariable(value = "date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2){
        return articleRealiseeService.getArticlesRealiseesparPeriode(bcId,date1,date2);
    }

    @GetMapping("/articlesRealiseesJoinbydate/{bcId}/date/{dateA}")
    public List<ArticleR> getArticlesRealiseesbyDate(@PathVariable(value = "bcId") long bcId, @PathVariable(value = "dateA") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateA){
        return articleRealiseeService.getArticlesRealiseesbyDate(bcId,dateA);
    }

    @GetMapping("/articlesRealiseesJoinGlobalbyBC/{bcId}")
    public List<ArticleR> getArticlesRealiseesGlobalby(@PathVariable(value = "bcId") long bcId){
        return articleRealiseeService.getArticlesRealiseesGlobalbyBC(bcId);
    }
}
