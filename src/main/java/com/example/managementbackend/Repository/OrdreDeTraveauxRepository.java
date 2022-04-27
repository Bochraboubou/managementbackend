package com.example.managementbackend.Repository;

import com.example.managementbackend.model.OrdreDeTraveaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdreDeTraveauxRepository extends JpaRepository<OrdreDeTraveaux, Long> {
   public List<OrdreDeTraveaux > findBybonDeCommandeId(Long id);
}
