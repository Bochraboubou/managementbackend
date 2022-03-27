package com.example.managementbackend.Repository;

import com.example.managementbackend.model.ImageMdel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ImageRepository extends JpaRepository<ImageMdel,String> {
    Optional<ImageMdel> findByName(String name);
}
