package com.example.managementbackend.Service;

import com.example.managementbackend.model.Role;
import com.example.managementbackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    Role saveRole (Role role );
    void addRoleToUser( String userName, String roleName);
    User getUser( String username);
    List<User> getUsers();
    public  User find(String username);
}
