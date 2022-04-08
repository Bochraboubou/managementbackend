package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.SecteurService;
import com.example.managementbackend.Service.UniteeMonneeService;
import com.example.managementbackend.model.Secteur;
import com.example.managementbackend.model.UniteeMonnee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/admin")
@RestController
public class UniteeMonneeController {

    @Autowired
    private UniteeMonneeService uniteeMonneeService;


    @GetMapping("/unitees")
    public List<UniteeMonnee> getAll() {
        return uniteeMonneeService.getAll();
    }

    @PostMapping("/unitee")
    public UniteeMonnee createUniteeMonnee(@Valid @RequestBody UniteeMonnee unitee) {
        return uniteeMonneeService.createUnitee(unitee);
    }
}
