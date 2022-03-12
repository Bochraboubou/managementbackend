package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository  extends JpaRepository<Demande,Long> {
    Demande findDemandeById( Long  id );
}
