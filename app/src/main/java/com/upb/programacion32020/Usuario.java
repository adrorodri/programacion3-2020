package com.upb.programacion32020;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String nombre;
    private String username;
    private String password;
    private int image;

    Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    Usuario(String nombre, int image) {
        this.nombre = nombre;
        this.image = image;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
