package com.example.managementbackend.Controller;

import com.example.managementbackend.Repository.OrganisationRepository;
import com.example.managementbackend.Repository.ProspectRepository;
import com.example.managementbackend.Repository.UserRepository;
import com.example.managementbackend.Service.UserService;
import com.example.managementbackend.dto.organisationUserJoin;
import com.example.managementbackend.model.Demande;
import com.example.managementbackend.model.Prospect;
import com.example.managementbackend.model.Response;
import com.example.managementbackend.model.User;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    @Autowired
    ServletContext context ;

    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        List<User> users =userService.getUsers();
        return  new ResponseEntity<>(users, HttpStatus.OK);

    }
    @PostMapping("/save")
    public  User saveUsers(@RequestBody User user){

        return userRepository.save(user);

    }
    //delete one user
    @DeleteMapping("/deleteUser/{id}")
    public void delete(@PathVariable Long id){
userService.Delete(id);

    }
    //delete all users
    @DeleteMapping("/deleteAllUsers")
    public void deleteAllusers(){
        userService.DeleteAll();

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

    @PostMapping("/addToUser/{username}/role/{rolename}")
    public void addRoleToUser(@PathVariable  String username, String rolename){
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






    //save Simple User
    @PostMapping("/premierFois/{organId}")
    public User PremierAjout( @PathVariable (value = "organId") Long organId,@RequestBody  User user ){
        return  userService.premierFois(organId,user);
    }

  //
  @GetMapping("/addroles/{username}/role/{role}")

  public User PremierAjout( @PathVariable (value = "username") String username,@PathVariable (value = "role")   String role ){
      return  userService.addRole(username,role);
  }



////save user "image"


    @PostMapping("/userenew/{idorg}/role/{idrole}")
    public ResponseEntity<Response> saveUserUser (@RequestParam("file") MultipartFile file,
                                                 @RequestParam("user") String user,@PathVariable Long idorg,@PathVariable Long idrole) throws JsonParseException, JsonMappingException, Exception
    {
        System.out.println("Ok .............");
        User user1 = new ObjectMapper().readValue(user, User.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        user1.setImage(newFileName);
        User art = userService.saveUser(idorg,idrole,user1);
        if (art != null)
        {
            return new ResponseEntity<Response>(new Response ("aucune donne inserer"),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(new Response ("user n est pas sauvegarde"),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(path="/ImgUser/{id}")
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{

        User user  = userRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+user.getImage()));
    }
    @PutMapping("/updateUser/{id}")
    public void updateUSER(@RequestBody  User user,@PathVariable Long id ){

        userService.updateUser(user,id);
    }



    @PostMapping("/updateSamedi/{id}")
    public ResponseEntity<Response> update (@RequestParam("file") MultipartFile file,
                                                 @RequestParam("user") String user, @PathVariable Long id) throws JsonParseException, JsonMappingException , Exception
    {
        System.out.println("Ok .............");
        User user1 = new ObjectMapper().readValue(user, User.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
            new File (context.getRealPath("/Images/")).mkdir();
            System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
            System.out.println("Image");
            FileUtils.writeByteArrayToFile(serverFile,file.getBytes());

        }catch(Exception e) {
            e.printStackTrace();
        }


        user1.setImage(newFileName);
        User art = userService.updateUser(user1,id);
        if (art != null)
        {
            return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<Response>(new Response ("USER not saved"),HttpStatus.BAD_REQUEST);
        }
    }


    // find users of one organisation
    @GetMapping("/mycpm/{code}")
    public List<organisationUserJoin> findUsersOneOrg(@PathVariable String code ){
       return  userRepository.getAdminMyCpm(code);
    }
// get all users with code organisation


    @GetMapping("/allusersBYQuery")
    public List<organisationUserJoin> findUsersOneOrg(){
        return  userRepository.getAllUsers();
    }



// Delete All organisation's user

    @DeleteMapping("/DeleteAllOrg_User/{idOrg}")
    public void  DeleteAllOrg_users(@PathVariable  Long idOrg)
    {
        userService.DeleteAllOrg_User(idOrg);
    }



}
