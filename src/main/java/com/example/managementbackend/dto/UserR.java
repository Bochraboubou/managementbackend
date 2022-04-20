package com.example.managementbackend.dto;

import com.example.managementbackend.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserR {
   private  Long id;
   private String adresse;
    private String username;
    private String email;
    List<Role> roles ;

    public UserR(long id, String adresse, String username, String email, List<Role> roles) {
        this.id = id;
        this.adresse = adresse;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
    public UserR( String adresse, String username, String email, List<Role> roles) {

        this.adresse = adresse;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }
}
