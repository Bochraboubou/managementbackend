package com.example.managementbackend.model;

import javax.persistence.*;

@Entity

@Table(name = "image_table")
public class ImageMdel {
@Id
 @Column(name = "id")
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
  @Column(name = "name")
 private String name;
 @Column(name = "type")
 private String type;
 @Column(name = "picByte", length = 1000)
 private byte[] picByte;


    public ImageMdel(String name, String type, byte[] picByte) {

        this.name = name;

        this.type = type;

        this.picByte = picByte;

    }
    public ImageMdel() {
     super();
    }
    public String getName() {
        return name;

    }

    public void setName(String name) {
  this.name = name;

    }

    public String getType() {
  return type;
    }

    public void setType(String type) {

        this.type = type;

    }
    public byte[] getPicByte() {

        return picByte;

    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }

}
