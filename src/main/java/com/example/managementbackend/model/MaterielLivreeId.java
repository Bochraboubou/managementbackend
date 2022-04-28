package com.example.managementbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class MaterielLivreeId implements Serializable  {

    Long  BonLivraison_id;
    Long article_id;

}
