package com.example.managementbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Data
public class Prospect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String code;
    private Long id_org;
    private Long id_role;

    public Prospect(Long id, String email, String code, Long id_org, Long id_role) {
        this.id = id;
        this.email = email;
        this.code = code;
        this.id_org = id_org;
        this.id_role = id_role;
    }
}
