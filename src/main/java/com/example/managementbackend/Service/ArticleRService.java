package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.ArticleUtiliseeRepository;
import com.example.managementbackend.dto.ArticleR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArticleRService {
    @Autowired
    private ArticleRepository articleRepo;

    @Autowired
    private ArticleUtiliseeRepository articleUtiliseeRepo;


    public List<ArticleR> getArticlesUtilisees(long bcId){
        return articleRepo.getArticlesUtilisees(bcId);
    }

    public List<ArticleR> getArticlesJoins(){ return articleRepo.getAllArticlesJoins();}

    public List<ArticleR> getArticlesJoinsbyMetier(long metierId){return articleRepo.getArticlesJoinsByMetier(metierId);}

    public List<ArticleR> getArticlesRealiseesparPeriode(long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date2){
        return articleRepo.getArticlesRealiseesByBCbyPeriode(bcId,date1,date2);
    }

    public List<ArticleR> getArticlesRealiseesbyDate(long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dateA){
        return articleRepo.getArticlesRealiseesByBCbyDate(bcId,dateA);
    }

    public List<ArticleR> getArticlesRealiseesGlobalbyBC(long bcId){
        return articleRepo.getArticlesRealiseesGlobalbyBC(bcId);
    }


}
