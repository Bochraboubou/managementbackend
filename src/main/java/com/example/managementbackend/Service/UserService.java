package com.example.managementbackend.Service;

import com.example.managementbackend.model.Role;
import com.example.managementbackend.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface UserService {
    User saveUser(Long organId ,Long roleId, User user);
    Role saveRole (Role role );
    void addRoleToUser( String userName, String roleName);
    User getUserByUsername( String username);
    List<User> getUsers();
     User find(String username);

    User fetchUserByUserNameandPassword(String username, String password);


    User fetchUserByEmail(String tempMail);
}
