package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Optional<Organisation> findByCode(String Code);

    Optional<Organisation> findByBonDeCommandesId(long bonDeCommandeId);


   Optional<Organisation> findByUsersId(Long  userId );

   Optional<Organisation> findByUsersUsername(String userName );

    Optional<Organisation> findByNom(String nom );

/*
@Query("SELECT  new com.example.managementbackend.dto.organisationUserJoin (o.nom ,u.username )FROM Organisation o JOIN o.users u")
    public List<organisationUserJoin> getInformations();


    @Query("SELECT  new com.example.managementbackend.dto.organisationUserJoin (o.nom ,u.username ,o.adresse)FROM Organisation o JOIN o.users u")
    public List<organisationUserJoin> getInformationsOrganisation();




 */

}

       // User findByEmailAddress(String emailAddress);



