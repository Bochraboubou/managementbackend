package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.RoleRepository;
import com.example.managementbackend.Service.RoleService;
import com.example.managementbackend.Service.UserService;
import com.example.managementbackend.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {

    @Autowired
    UserService userService;
@Autowired
    RoleService roleService;
    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/role/save")
    public Role saveRole(@RequestBody Role role){
         return userService.saveRole(role);

    }
    @GetMapping("/roles")
    public List<Role> Afficher(){
        return roleRepository.findAll();

    }
    @DeleteMapping("/delete/{id}")
    public void  deleteRole(@PathVariable Long id ){
         roleRepository.deleteById(id);
    }

    @PutMapping("/put/{rolename}")
    public Role  fetch(@PathVariable String rolename ){
       return  roleRepository.findByName(rolename);
    }


    @GetMapping("/getRoleUser/{id}")
    public List <Role> TrouverRoleUser(@PathVariable Long id){
        return roleService.findRole(id);
    }

    //////////////////////
    @GetMapping("/listeRoles/{id}")
    public List<Role>fff(@PathVariable Long id){
      return  roleRepository.findByUsersId(id);
    }
}
