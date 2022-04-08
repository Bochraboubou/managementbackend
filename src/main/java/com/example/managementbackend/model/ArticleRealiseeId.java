package com.example.managementbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ArticleRealiseeId implements Serializable {
    @Column(name = "attachement_id")
    private Long attachement_id;

    @Column(name = "article_id")
    private Long article_id;
}
