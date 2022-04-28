package com.example.managementbackend.Repository;

import com.example.managementbackend.model.ArticleRealisee;
import com.example.managementbackend.model.ArticleRealiseeId;
import com.example.managementbackend.model.OrdreDefinitif;
import com.example.managementbackend.model.OrdreDefinitifId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdreDefintifRepository extends JpaRepository<OrdreDefinitif, OrdreDefinitifId> {
    public List<OrdreDefinitif>findByordreDeTraveauxId( Long id);
}
