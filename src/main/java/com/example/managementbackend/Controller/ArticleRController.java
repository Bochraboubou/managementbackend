package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.ArticleRService;
import com.example.managementbackend.Service.ArticleService;
import com.example.managementbackend.dto.ArticleR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/admin")
@RestController
public class ArticleRController {
    @Autowired
    private ArticleRService articleRealiseeService;


    @GetMapping("/articlesRealisees/{bcId}")
    public List<ArticleR> getArticlesUtilisee(@PathVariable long bcId){
        return articleRealiseeService.getArticlesRealisees(bcId);
    }

    @GetMapping("/articlesJoins")
    public List<ArticleR> getArticlesJoins(){
        return articleRealiseeService.getArticlesJoins();
    }


    @GetMapping("/articlesJoinsByMetier/{metierId}")
    public List<ArticleR> getArticlesJoinsbyMetier(@PathVariable long metierId){
        return articleRealiseeService.getArticlesJoinsbyMetier(metierId);
    }
}
