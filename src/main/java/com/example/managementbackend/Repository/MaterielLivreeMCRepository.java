package com.example.managementbackend.Repository;

import com.example.managementbackend.model.MaterielLivreeMCId;
import com.example.managementbackend.model.MaterielleLivreeMC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterielLivreeMCRepository extends JpaRepository<MaterielleLivreeMC, MaterielLivreeMCId> {
}
