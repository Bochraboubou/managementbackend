package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.MetierRepository;
import com.example.managementbackend.Repository.SecteurRepository;
import com.example.managementbackend.Repository.TypeRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Metier;
import com.example.managementbackend.model.Secteur;
import com.example.managementbackend.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepo;

    @Autowired
    private MetierRepository metierRepo;

    public List<Type> getAll() {
        return typeRepo.findAll();
    }


    public Optional<Type> geTypebyLib(String typeLib) {
        return typeRepo.findByTypeLib(typeLib).map(type -> typeRepo.findByTypeLib(typeLib)).orElseThrow(() -> new ResourceNotFoundException("typeLib " + typeLib+ " not found"));
    }

    public Optional<Type> geTypebyArticle(long articleId) {
        return typeRepo.findByArticlesId(articleId).map(type -> typeRepo.findByArticlesId(articleId)).orElseThrow(() -> new ResourceNotFoundException("ArticleId " + articleId+ " not found"));
    }


    public Optional<Type> getTypebyId(long idType) {
        return typeRepo.findById(idType).map(secteur -> typeRepo.findById(idType)).orElseThrow(() -> new ResourceNotFoundException("idSecteur " + idType+ " not found"));
    }

    public List<Type> getAllTypesByMetierId(Long metierId) {
        return typeRepo.findByMetierId(metierId);
    }


    public Type create(Long metierId,Type type) {
        return metierRepo.findById(metierId).map(metier -> {
            type.setMetier(metier);
            return typeRepo.save(type);
        }).orElseThrow(() -> new ResourceNotFoundException("metierId " + metierId + " not found"));
    }






    public ResponseEntity<?> deleteType(Long typeId) {
        return typeRepo.findById(typeId).map(type -> {
            typeRepo.delete(type);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + typeId + " not found"));
    }
}
