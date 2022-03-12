package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.RoleRepository;
import com.example.managementbackend.Repository.UserRepository;
import com.example.managementbackend.model.Role;
import com.example.managementbackend.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service @Slf4j
public class UserServiceImpl  implements UserService{

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public  User find(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        log.info("saving user  {}to the data base ", user.getUsername());
       return  userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("saving role {}  to the data base ", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding role {} to  user {}  ", roleName,username);
        User u = userRepository.findByUsername(username);
        Role r= roleRepository.findByName(roleName);

        log.info("step one ");
        u.getRoles().add(r);
    }

    @Override
    public User getUser(String username) {
        log.info("getting user {} from the the data base ", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("getting all users from the data base ");
 return userRepository.findAll();
    }
}
