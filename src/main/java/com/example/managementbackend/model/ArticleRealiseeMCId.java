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
public class ArticleRealiseeMCId implements Serializable {
    private static final long serialVersionUID = -2540698985772832374L;
    @Column(name = "attachementMC_id")
    private Long attachementMC_id;

    @Column(name = "article_id")
    private Long article_id;
}
