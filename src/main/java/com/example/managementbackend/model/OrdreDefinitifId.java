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
public class OrdreDefinitifId implements Serializable {
    @Column(name = "ordreDeTraveaux_id")
    private Long ordreDeTraveaux_id;

    @Column(name = "article_id")
    private Long article_id;
}
