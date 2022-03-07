package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Optional<Organisation> findByCode(String Code);
   /*
    List<Organisation> findBySuporganId(long suporganId);

    Optional<Organisation> findByIdAndSuporganId(long id, long suporganId);

    */
}
