package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.Repository.ProspectRepository;
import com.example.managementbackend.Repository.UserRepository;
import com.example.managementbackend.Service.UserService;
import com.example.managementbackend.model.Organisation;
import com.example.managementbackend.model.Prospect;
import com.example.managementbackend.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

@Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    ProspectRepository prospectRepository;
    @Autowired
    OrganisationRepository orgRepo;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        List<User> users =userService.getUsers();
        return  new ResponseEntity<>(users, HttpStatus.OK);

    }
    @PostMapping("/save")
    public  User saveUsers(@RequestBody User user){

        return userRepository.save(user);

    }



    @GetMapping("/find/{username}")
    public User findUser(@PathVariable String username)
    {

        return userService.getUserByUsername(username);
    }

    @PostMapping("/role/addToUser")
    public void addRoleToUser(@RequestBody  String username, String rolename){
       userService.addRoleToUser(username,rolename);
    }
// --------------------my first code mercredi   123
@PostMapping("/registerUser/{organId}/role/{roleId}")
public User registerUser( @PathVariable (value = "organId") Long organId,@PathVariable  (value = "roleId") Long roleId, @Valid @RequestBody User user) throws Exception {
    String emmail = user.getEmail();
    if (emmail != null && !"".equals(emmail)) {
        User userObj = userRepository.findByEmail(emmail);
        Prospect userObj2= prospectRepository.findByEmail(emmail);
        if (userObj != null) {
            throw new Exception("User with " + emmail + "is already exist");
        }
        if (userObj2 == null) {
            throw new Exception("User with " + emmail + " n a pas fait une demande");
        }
    }

    User userObj = null;
    userObj = userService.saveUser(organId,roleId,user);
    return userObj;
}

    @PostMapping("/login")
    public User LoginUser(@RequestBody User user) throws Exception {
        String name = user.getUsername();
        String pass = user.getPassword();

        User userObj = null;
        if (name != null && pass != null) {

            userObj  = userService.fetchUserByUserNameandPassword(name, pass);

        }
        if (userObj == null) {
            throw new Exception("bad pass or login");
        }
        return userObj;
    }




    /*@GetMapping("/f/{mail}")
    public User findUser(@PathVariable(name = "mail") String mail) throws Exception {


        User u = userRepository.findByEmail(mail);
        if (u != null)
            System.out.println(u.getCode_org());
        return u;

    }
    @GetMapping("/login")
    public User LoginUser(@RequestBody User user) throws Exception {
        String tempMail = user.getEmail();
        String temppass = user.getPassword();
        String tempCode = user.getCode_org();
        User userObj = null;
        if (tempMail != null && temppass != null) {
            User u1=userService.fetchUserByEmail(tempMail);
            userObj  = userService.fetchUserByEmailandPassword(tempMail, temppass);

        }
        if (userObj == null) {
            throw new Exception("bad pass or login");
        }
        return userObj;
    }

     */

}
