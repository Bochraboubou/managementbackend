package com.example.managementbackend.Service;

import com.example.managementbackend.model.Role;
import com.example.managementbackend.model.User;

import java.util.List;
import java.util.Optional;

//@Service
public interface UserService {
    User saveUser(Long organId ,Long roleId, User user);
    Role saveRole (Role role );
    void addRoleToUser( String userName, String roleName);
    User getUserByUsername( String username);
    List<User> getUsers();
     User find(String username);

    User fetchUserByUserNameandPassword(String username, String password);

  List <User> findUser(Long id );
   Optional<User> findUserById(Long id);

    User fetchUserByEmail(String tempMail);
    public User premierFois(Long organId ,User user);

    public void Delete(Long id);
    public List <User> trouverEmployer(Long id );
    public User addRole( String username, String role);
    public User updateUser(User user, Long id );
    public void DeleteAll();
}
