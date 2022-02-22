package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Entreprise;
import com.example.managementbackend.model.Organisation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

   Page<Entreprise> findByOrganisationId(long organisationId, Pageable pageable);
    Optional<Entreprise> findByIdAndOrganisationId(long id, long organisationId);
}
