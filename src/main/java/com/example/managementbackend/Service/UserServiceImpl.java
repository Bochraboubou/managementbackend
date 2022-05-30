package com.example.managementbackend.Service;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.Repository.RoleRepository;
import com.example.managementbackend.Repository.UserRepository;
import com.example.managementbackend.exception.ResourceNotFoundException;
import com.example.managementbackend.model.Role;
import com.example.managementbackend.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
@Slf4j
public class UserServiceImpl  implements UserService {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    OrganisationRepository organRepo;


    @Override
    public User find(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void Delete(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public void DeleteAll() {
        userRepository.deleteAll();
    }

// delete oll user of one organisation
    @Override
    public void DeleteAllOrg_User(Long idOrg) {

        // get  all organisaton users by id_org
        List<User> liste = userRepository.findByOrganisationId(idOrg);
        for(User u :liste){
           Long  id=u.getId();
           Delete(id);
       }

        // delete all users




    }

    @Override
    public User saveUser(Long organId, Long roleId, User user) {
        MultipartFile file = null;
        log.info("saving user  {}to the data base ", user.getUsername());
        return organRepo.findById(organId).map(organisation -> {
            return roleRepository.findById(roleId).map(role -> {
                Role rolee = roleRepository.getById(roleId);
                user.setOrganisation(organisation);

                user.getRoles().add(rolee);
                // user.setRoles(roles);
                return userRepository.save(user);
            }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));
        }).orElseThrow(() -> new ResourceNotFoundException("roleId  " + roleId + " not found"));
    }


    @Override
    public Role saveRole(Role role) {
        log.info("saving role {}  to the data base ", role.getName());
        return roleRepository.save(role);
    }


    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding role {} to  user {}  ", roleName, username);
        User u = userRepository.findByUsername(username);
        Role r = roleRepository.findByName(roleName);

        log.info("step one ");
        u.getRoles().add(r);
    }


    @Override
    public User getUserByUsername(String username) {
        log.info("getting user {} from the the data base ", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("getting all users from the data base ");
        return userRepository.findAll();
    }


    /*public User fetchUserByEmail(String email){

        return   userRepository.findByEmail(email);
    }
    */
    @Override
    public User fetchUserByUserNameandPassword(String name, String password) {

        return userRepository.findByUsernameAndPassword(name, password);
    }

    @Override
    public User fetchUserByEmail(String tempMail) {
        return userRepository.findByEmail(tempMail);
    }


    // get user by id organisation ::
    @Override
    public List<User> findUser(Long id) {

        return userRepository.findByOrganisationId(id);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    //Simple user


    @Override
    public User premierFois(Long organId, User user) {
        log.info("saving user  {}to the data base ", user.getUsername());
        return organRepo.findById(organId).map(organisation -> {

            user.setOrganisation(organisation);


            // user.setRoles(roles);
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException("organId " + organId + " not found"));

    }

    @Override
    public List<User> trouverEmployer(Long idOrg) {

        List<User> liste = userRepository.findByOrganisationId(idOrg);
        List<User> listfinale = new ArrayList<>();
        for (User u : liste) {
            List<Role> rolesUser = new ArrayList<>();
            Long iduser = u.getId();
            rolesUser = roleRepository.findRoleByUsersId(iduser);
            for (Role r : rolesUser) {
                if (r.getId() == 7) {
                    listfinale.add(u);
                }

            }

        }

        return listfinale;
    }
@Override
    public User addRole(@PathVariable String username, String role) {
        User u = userRepository.findByUsername(username);
        Role r = roleRepository.findByName(role);
        if ((u != null ) && (r != null)  ) {

             List <Role> liste=u.getRoles();
            liste.add(r);
             for(Role ro:liste){
                 if(ro.getName().equals("SIMPLE")){
                   liste.remove(ro);
                 }
             }

             u.setRoles(liste);


        }else{
            System.out.println("check user and  role ");
        }
        return userRepository.save(u);
    }


    //update
    public User updateUser(User user, Long id ){
        User user1=userRepository.getById(id);

       user1.setName(user.getName());
        user1.setUsername(user.getUsername());
        user1.setAdresse(user.getAdresse());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        user1.setImage(user.getImage());
        user1.setActive(user.isActive());
        user1.setDatenaissance(user.getDatenaissance());
        user1.setRoles(user.getRoles());
        return userRepository.save(user1);

    }

}