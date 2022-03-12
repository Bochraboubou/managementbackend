package com.example.managementbackend.Controller;

import com.example.managementbackend.Service.UserService;
import com.example.managementbackend.model.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(){
        List<User> users =userService.getUsers();
        return  new ResponseEntity<>(users, HttpStatus.OK);

    }
    @PostMapping("/user/save")
    public ResponseEntity<User>saveUsers(@RequestBody User user){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return  ResponseEntity.created(uri).body(userService. saveUser(user));

    }
    @GetMapping("/find")
    public User findUser(@RequestBody String username){
        return userService.getUser(username);
    }
    @PostMapping("/role/addToUser")
    public ResponseEntity<?>addRoleToUser(@RequestBody  RoleToUserForm ru){
        userService.addRoleToUser(ru.getUsername(),ru.getRolename());
        return  ResponseEntity.ok().build();

    }

}
@Data
class RoleToUserForm{
    public  String username;
    public String rolename ;
}