package com.example.managementbackend.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AticleUtiliseeId implements Serializable {
    @Column(name = "bondecommande_id")
    private Long bondecommande_id;

    @Column(name = "article_id")
    private Long article_id;

    public AticleUtiliseeId(Long bondecommande_id, Long article_id) {
        this.bondecommande_id = bondecommande_id;
        this.article_id = article_id;
    }

    public AticleUtiliseeId() {

    }

    public Long getBondecommande_id() {
        return bondecommande_id;
    }

    public void setBondecommande_id(Long bondecommande_id) {
        this.bondecommande_id = bondecommande_id;
    }

    public Long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Long article_id) {
        this.article_id = article_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AticleUtiliseeId)) return false;
        AticleUtiliseeId that = (AticleUtiliseeId) o;
        return bondecommande_id.equals(that.bondecommande_id) && article_id.equals(that.article_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bondecommande_id, article_id);
    }
}
