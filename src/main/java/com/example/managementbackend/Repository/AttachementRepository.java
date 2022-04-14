package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.ArticleR;
import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.Metier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttachementRepository extends JpaRepository<Attachement, Long> {

    public Attachement findByCodeAttachement(String code);


    /*List<Attachement> findByDateAttachementBetween(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);*/

    @Query("SELECT a FROM Attachement a where a.dateAttachement between :date1 and  :date2")
    public List<Attachement> getbetweendate(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2);

}

