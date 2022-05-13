package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Marchee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT m FROM  Marchee m join  m.org o where o.id = :orgId and m.type = 'projet'")
    public List<Marchee> getAllMarcheeProjetbyOrg(@Param("orgId") long orgId);

    @Query("SELECT m FROM  Marchee m join  m.org o where o.id = :orgId and m.type = 'MC'")
    public List<Marchee> getAllMarcheeMCbyOrg(@Param("orgId") long orgId);
}
