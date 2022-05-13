package com.example.managementbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ArticleDTO {
    private Long id;

    private String code;

    private String designation;

    private String unitee;

    private  String classe;

    private float prix;

    private float quantitee;

    private double quantiteeRealisee;

    private  long idType;

    private  String typeLib;

    public ArticleDTO(Long id, String code, String designation, String unitee, String classe, long idType, String typeLib) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.classe=classe;
        this.idType = idType;
        this.typeLib = typeLib;
    }

    public ArticleDTO(Long id, String code, String designation, String unitee, float prix, float quantitee, long idType, String typeLib) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.prix = prix;
        this.quantitee = quantitee;
        this.idType = idType;
        this.typeLib = typeLib;
    }

    public ArticleDTO(Long id, String code, String designation, String unitee, double quantiteeRealisee, long idType, String typeLib) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.quantiteeRealisee = quantiteeRealisee;
        this.idType = idType;
        this.typeLib = typeLib;
    }
}
