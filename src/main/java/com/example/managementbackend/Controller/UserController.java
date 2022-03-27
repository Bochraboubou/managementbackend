package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.Repository.ProspectRepository;
import com.example.managementbackend.Repository.UserRepository;
import com.example.managementbackend.Service.UserService;
import com.example.managementbackend.model.Prospect;
import com.example.managementbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    // find userById
    @GetMapping("/getById/{id}")
    public Optional<User> getById(@PathVariable Long id ){

        return userService.findUserById(id);

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
    //save pour admin
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

    //save pour un simple utulisateur
    @PostMapping("/registerSimpleUser/{organId}/role/{roleId}")
    public User registerSimpleUser( @PathVariable (value = "organId") Long organId,@PathVariable  (value = "roleId") Long roleId, @Valid @RequestBody User user) throws Exception {
        String emmail = user.getEmail();
        if (emmail != null && !"".equals(emmail)) {
            User userObj = userRepository.findByEmail(emmail);
            Prospect userObj2= prospectRepository.findByEmail(emmail);
            if (userObj != null) {
                throw new Exception("User with " + emmail + "is already exist");
            }
            if (userObj2 != null) {
                throw new Exception("User with " + emmail + " a fait une demande");
            }
        }

        User userObj = null;
        userObj = userService.saveUser(organId,roleId,user);
        return userObj;
    }

@GetMapping("/getOrganiation/{id}")
public List <User> finduserByOrganisation(@PathVariable Long id ){
        return userService.findUser(id);

}
    @GetMapping("/findbyEmail/{email}")
 public User trouverParEmail(@PathVariable String email){
        return userRepository.findByEmail(email);
}



    @GetMapping("/findbyRole/{roleid}")
    public List<User> trouverParEmail(@PathVariable Long  roleid){

        return userRepository.findByRolesId(roleid);
    }

    @GetMapping("/trouverEmployee/{orgID}")
    public List<User> findEmployee(@PathVariable Long  orgID){

        return userService.trouverEmployer(orgID);
    }





    // the first one
    //dont drop

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


    //save Simple User
    @PostMapping("/premierFois/{organId}")
    public User PremierAjout( @PathVariable (value = "organId") Long organId,@RequestBody  User user ){
        return  userService.premierFois(organId,user);
    }
}
