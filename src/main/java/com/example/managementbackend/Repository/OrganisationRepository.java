package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.ArticleR;
import com.example.managementbackend.dto.BondeCommandeJoin;
import com.example.managementbackend.model.Organisation;
import com.example.managementbackend.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Optional<Organisation> findByCode(String Code);

    Optional<Organisation> findByBonDeCommandesId(long bonDeCommandeId);

    Optional<Organisation> findByUsersId(Long userId);

    Optional<Organisation> findByNom(String nom);

    Optional<Organisation> findByUsersUsername(String userName);
}



