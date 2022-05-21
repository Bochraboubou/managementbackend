package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.AttachementMC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachementMCRepository extends JpaRepository<AttachementMC, Long> {
    public AttachementMC findBycodeAttachementMC(String code );
    public List<AttachementMC>findByOrdreTraveauxId(Long id );
}
