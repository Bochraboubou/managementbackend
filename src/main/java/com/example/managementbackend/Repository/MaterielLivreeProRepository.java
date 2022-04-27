package com.example.managementbackend.Repository;

import com.example.managementbackend.model.MaterielLivreeId;
import com.example.managementbackend.model.MaterielLivreePro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielLivreeProRepository  extends JpaRepository<MaterielLivreePro, MaterielLivreeId> {
}
