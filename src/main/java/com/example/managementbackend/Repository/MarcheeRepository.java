package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Marchee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MarcheeRepository extends JpaRepository<Marchee, Long> {
    List<Marchee> findByOrgId(long organisationId);
    Optional<Marchee> findByIdAndOrgId(long id, long organisationId);
    Optional<Marchee> findByCode(String code);
    Optional<Marchee> findByCodeAndOrgId(String code,long orgId);
    Optional<Marchee[]> findByMetierIdAndOrgId(long metierId,long orgId);

}
