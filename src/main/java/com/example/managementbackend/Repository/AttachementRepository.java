package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Attachement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachementRepository extends JpaRepository<Attachement, Long> {
    public Attachement findByCodeAttachement(String code);

}
