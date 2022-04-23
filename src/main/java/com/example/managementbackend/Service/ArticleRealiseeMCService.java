package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.*;
import com.example.managementbackend.dto.ArticleR;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.ArticleRealiseeId;
import com.example.managementbackend.model.ArticleRealiseeMC;
import com.example.managementbackend.model.ArticleRealiseeMCId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArticleRealiseeMCService {
    @Autowired
    private ArticleRealiseeMCRepository articleRealiseeMCRepo;

    @Autowired
    private AttachementMCRepository attachementMCRepo;

    @Autowired
    private ArticleRepository articleRepo;


    public List<ArticleRealiseeMC> getAll() {
        return articleRealiseeMCRepo.findAll();
    }

    public ArticleRealiseeMC create(Long attachementMCId,Long articleid,ArticleRealiseeMC articleRealiseeMC) {
        return attachementMCRepo.findById(attachementMCId).map(attachementMC -> {
            return articleRepo.findById(articleid).map(article -> {
                articleRealiseeMC.setId(new ArticleRealiseeMCId(attachementMCId,articleid));
                articleRealiseeMC.setAttachementMC(attachementMC);
                articleRealiseeMC.setArticle(article);
                return articleRealiseeMCRepo.save(articleRealiseeMC);

            }).orElseThrow(() -> new ResourceNotFoundException("articleId " + articleid + " not found"));

        }).orElseThrow(() -> new ResourceNotFoundException("attachementMCId " + attachementMCId + " not found"));
    }


    public List<ArticleR> getArticlesRealiseesPrestationparPeriodeByOT(long otId, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date2){
        return articleRealiseeMCRepo.getArticlesRealiseesPrestationByOTbyPeriode(otId,date1,date2);
    }

    public List<ArticleR> getArticlesRealiseesPrestationbyDateByOT(long otId, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dateA){
        return articleRealiseeMCRepo.getArticlesRealiseesPrestationByOTbyDate(otId,dateA);
    }

    public List<ArticleR> getArticlesRealiseesPrestationGlobalByOT(long otId){
        return articleRealiseeMCRepo.getArticlesRealiseesPrestationGlobalbyOT(otId);
    }

    public List<ArticleR> getArticlesRealiseesMFparPeriodeByOT(long otId, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date1, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date2){
        return articleRealiseeMCRepo.getArticlesRealiseesMFByOTbyPeriode(otId,date1,date2);
    }

    public List<ArticleR> getArticlesRealiseesMFbyDateByOT(long otId, @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate dateA){
        return articleRealiseeMCRepo.getArticlesRealiseesMFByOTbyDate(otId,dateA);
    }

    public List<ArticleR> getArticlesRealiseesMFGlobalByOT(long otId){
        return articleRealiseeMCRepo.getArticlesRealiseesMFGlobalbyOT(otId);
    }


}
