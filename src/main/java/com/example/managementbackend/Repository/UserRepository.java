package com.example.managementbackend.Repository;

import com.example.managementbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
    public User findByEmail(String mail);
    public User findByUsernameAndPassword(String username ,String password);


}
