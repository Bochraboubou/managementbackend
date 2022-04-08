package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.UniteeMonneeRepository;
import com.example.managementbackend.model.Secteur;
import com.example.managementbackend.model.Type;
import com.example.managementbackend.model.UniteeMonnee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniteeMonneeService {
    @Autowired
    private UniteeMonneeRepository uniteeMonneeRepo;

    public List<UniteeMonnee> getAll() {
        return uniteeMonneeRepo.findAll();
    }


    public UniteeMonnee createUnitee(UniteeMonnee unitee) {
        return uniteeMonneeRepo.save(unitee);
    }
}
