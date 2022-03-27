package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.RoleRepository;
import com.example.managementbackend.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List <Role>  findRole(Long id){
     return   roleRepository.findRoleByUsersId(id);
 }
 // get all roles
    public List<Role>getAll(){
        return roleRepository.findAll();
    }

}
