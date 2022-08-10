package com.jonnathan.gallegos.usuarios.Modelo;

import java.io.Serializable;

public class ModeloUsuario implements Serializable {

    private String id;
    private String author;
    private String en;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", en='" + en + '\'' +
                '}';
    }
}
