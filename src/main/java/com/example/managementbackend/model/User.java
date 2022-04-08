package com.example.managementbackend.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(	name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(max = 20)
    private String username;

    private String name;
   private String adresse;
    private java.sql.Date datenaissance;
    @Email
    private String email;
    @NotNull
    private long tel;
    private String  image;

    @NotBlank
    @Size(max = 120)
    private String password;
    private  boolean active ;

    @JsonIgnore
    @ManyToMany
    @JoinTable( name = "T_Users_Roles_Associations",
            joinColumns = @JoinColumn( name = "idUser" ),
            inverseJoinColumns = @JoinColumn( name = "idRole" ) )
    private List<Role> roles = new ArrayList<>();
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "organisation_id", nullable = false)
    private Organisation organisation;


}
