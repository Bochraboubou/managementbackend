package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.ArticleRepository;
import com.example.managementbackend.Repository.ArticleUtiliseeRepository;
import com.example.managementbackend.dto.ArticleR;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ArticleRService {
    @Autowired
    private ArticleRepository articleRepo;

    @Autowired
    private ArticleUtiliseeRepository articleUtiliseeRepo;


    public List<ArticleR> getArticlesRealisees(long bcId){
        return articleRepo.getArticlesRealisees(bcId);
    }

    public List<ArticleR> getArticlesJoins(){ return articleRepo.getAllArticlesJoins();}

    public List<ArticleR> getArticlesJoinsbyMetier(long metierId){return articleRepo.getArticlesJoinsByMetier(metierId);}
}
