package com.example.managementbackend.Repository;

import com.example.managementbackend.model.Metier;
import com.example.managementbackend.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Type> findByMetierId(long MetierId);
    Optional<Type> findByTypeLib(String typeLib);
}
