package com.example.managementbackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ArticleR {
    private Long id;

    private String code;

    private String designation;

    private String unitee;

    private  String classe;

    private float prix;

    private long quantitee;

    private long quantiteeRealisee;

    private  long idType;

    private  String typeLib;

    public ArticleR(Long id, String code, String designation, String unitee,String classe, long idType, String typeLib) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.classe=classe;
        this.idType = idType;
        this.typeLib = typeLib;
    }

    public ArticleR(Long id, String code, String designation, String unitee, float prix, long quantitee, long idType, String typeLib) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.prix = prix;
        this.quantitee = quantitee;
        this.idType = idType;
        this.typeLib = typeLib;
    }

    public ArticleR(Long id, String code, String designation, String unitee, long quantiteeRealisee, long idType, String typeLib) {
        this.id = id;
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.quantiteeRealisee = quantiteeRealisee;
        this.idType = idType;
        this.typeLib = typeLib;
    }
}
