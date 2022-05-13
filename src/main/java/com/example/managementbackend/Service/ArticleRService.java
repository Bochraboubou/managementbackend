package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.ArticleUtiliseeRepository;
import com.example.managementbackend.dto.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArticleRService {
    @Autowired
    private ArticleRepository articleRepo;

    @Autowired
    private ArticleUtiliseeRepository articleUtiliseeRepo;


    public List<ArticleDTO> getArticlesUtilisees(long bcId){
        return articleRepo.getArticlesUtilisees(bcId);
    }

    public List<ArticleDTO> getArticlesJoins(){ return articleRepo.getAllArticlesJoins();}

    public List<ArticleDTO> getArticlesJoinsbyMetier(long metierId){return articleRepo.getArticlesJoinsByMetier(metierId);}

    public List<ArticleDTO> getArticlesRealiseesPrestationparPeriode(long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date2){
        return articleRepo.getArticlesRealiseesPrestationByBCbyPeriode(bcId,date1,date2);
    }

    public List<ArticleDTO> getArticlesRealiseesPrestationbyDate(long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dateA){
        return articleRepo.getArticlesRealiseesPrestationByBCbyDate(bcId,dateA);
    }

    public List<ArticleDTO> getArticlesRealiseesPrestationGlobalbyBC(long bcId){
        return articleRepo.getArticlesRealiseesPrestationGlobalbyBC(bcId);
    }

    public List<ArticleDTO> getArticlesRealiseesMFparPeriode(long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date2){
        return articleRepo.getArticlesRealiseesMFByBCbyPeriode(bcId,date1,date2);
    }

    public List<ArticleDTO> getArticlesRealiseesMFbyDate(long bcId, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dateA){
        return articleRepo.getArticlesRealiseesMFByBCbyDate(bcId,dateA);
    }

    public List<ArticleDTO> getArticlesRealiseesMFGlobalbyBC(long bcId){
        return articleRepo.getArticlesRealiseesMFGlobalbyBC(bcId);
    }


}
