package com.example.managementbackend.dto;

import com.example.managementbackend.model.Role;
import com.example.managementbackend.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data

@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class organisationUserJoin implements Serializable {
   /* private Long id ;
private Long idOrg;
private User users;*/
    private Long id;
    private String code;
    private String adresse;
    private String username;
    private String email;



    public organisationUserJoin(Long id,String username, String adresse, String email,String code) {
        this.id=id;
     this.code=code;
        this.username = username;

        this.email=email;

        this.adresse = adresse;

    }




}
