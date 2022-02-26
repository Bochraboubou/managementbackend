package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Entreprise;
import com.example.managementbackend.model.Marchee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcheeRepository extends JpaRepository<Marchee, Long> {
    List<Marchee> findByOrgId(long organisationId);
    Optional<Marchee> findByIdAndOrgId(long id, long organisationId);

}
