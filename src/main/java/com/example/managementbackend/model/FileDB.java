package com.example.managementbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "files")
@AllArgsConstructor
@NoArgsConstructor
public class FileDB {
    @Id
    @GeneratedValue(generator = "uuid")

    @GenericGenerator(name = "uuid", strategy = "uuid2")

    private String id;
    private String name;
    private String type;
    @Lob
    private byte[] data;

    public FileDB(String name, String type, byte[] data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }
}
