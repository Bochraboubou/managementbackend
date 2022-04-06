package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.MetierService;
import com.example.managementbackend.Service.TypeService;
import com.example.managementbackend.model.Article;
import com.example.managementbackend.model.Metier;
import com.example.managementbackend.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@RequestMapping("/admin")
@RestController
public class TypeController {
    @Autowired
    private TypeService typeService;


    @GetMapping("/metier/{metierId}/types")
    public List<Type> getAllTypesByMetierId(@PathVariable(value = "metierId") Long metierId) {
        return typeService.getAllTypesByMetierId(metierId);
    }
    @GetMapping("/types")
    public List<Type> getAllTypes() {
        return typeService.getAll();
    }

    @GetMapping("/typebylib/{typeLib}")
    public Optional<Type> getTypebyLib(@PathVariable String typeLib) {
        return typeService.geTypebyLib(typeLib);
    }

    @GetMapping("/typebyArticle/{articleId}")
    public Optional<Type> getTypebyArticleId(@PathVariable long articleId) {
        return typeService.geTypebyArticle(articleId);
    }




    @GetMapping("/typebyid/{id}")
    public Optional<Type> getTypebyId(@PathVariable long id) {
        return typeService.getTypebyId(id);
    }

    @PostMapping("/metier/{metierId}/type")
    public Type createMetier(@PathVariable (value = "metierId") Long metierId,
                               @Valid @RequestBody Type type) {
        return typeService.create(metierId,type);
    }


    @PutMapping("/editType/{typeId}")
    public Type updateType(@PathVariable Long typeId, @Valid @RequestBody Type typeRequest) {
        return typeService.updateType(typeId,typeRequest);
    }


    @DeleteMapping("/types/{typeId}")
    public ResponseEntity<?> deleteType(@PathVariable (value = "typeId") Long typeId) {

        return typeService.deleteType(typeId);
    }
}
