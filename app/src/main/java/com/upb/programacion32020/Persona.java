package com.upb.programacion32020;

public class Persona {
    private String nombre;
    private int image;

    Persona(String nombre, int image) {
        this.nombre = nombre;
        this.image = image;
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
