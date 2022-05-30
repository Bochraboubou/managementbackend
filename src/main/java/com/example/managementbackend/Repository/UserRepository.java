package com.example.managementbackend.Repository;

import com.example.managementbackend.dto.organisationUserJoin;
import com.example.managementbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
    public User findByEmail(String mail);
    public User findByUsernameAndPassword(String username ,String password);

     List<User> findByOrganisationId( Long id);
    List<User> findByRolesId( Long id);



    @Query("select u from User u where u.email = ?1")
    public User find(String o);





    @Query("SELECT new com.example.managementbackend.dto.organisationUserJoin(u.id,u.username,u.adresse,u.email,o.code) FROM Organisation o JOIN o.users u where o.code = :code ")
    public List<organisationUserJoin> getAdminMyCpm(@Param("code") String code);


// get all users widh code  organisation

    @Query("SELECT new com.example.managementbackend.dto.organisationUserJoin(u.id,u.username,u.adresse,u.email,o.code) FROM Organisation o JOIN o.users u ")
    public List<organisationUserJoin> getAllUsers();



}


