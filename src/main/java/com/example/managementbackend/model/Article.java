package com.example.managementbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String code;

    @NotNull
    private String designation;


    @NotNull
    private String unitee;

    @NotNull
    private String classe;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "article",cascade = CascadeType.REMOVE)
    private List<ArticleUtilisee> bcassociation = new ArrayList<ArticleUtilisee>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(mappedBy = "article",cascade = CascadeType.REMOVE)
    private List<ArticleRealisee> articlesAttachees = new ArrayList<ArticleRealisee>();

    public Article() {

    }

    public Article(String code, String designation, String unitee, String classe, List<ArticleUtilisee> bcassociation, Type type, List<ArticleRealisee> articlesAttachees) {
        this.code = code;
        this.designation = designation;
        this.unitee = unitee;
        this.classe = classe;
        this.bcassociation = bcassociation;
        this.type = type;
        this.articlesAttachees = articlesAttachees;
    }
}
