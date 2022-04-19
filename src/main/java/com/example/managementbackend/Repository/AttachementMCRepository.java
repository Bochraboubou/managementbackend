package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Attachement;
import com.example.managementbackend.model.AttachementMC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachementMCRepository extends JpaRepository<AttachementMC, Long> {
}
