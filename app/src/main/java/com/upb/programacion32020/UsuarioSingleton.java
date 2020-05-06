package com.upb.programacion32020;

public class UsuarioSingleton {
    private static UsuarioSingleton instance;

    public Usuario usuario;

    private UsuarioSingleton() {
    }

    public static UsuarioSingleton getInstance() {
        if (instance == null) {
            instance = new UsuarioSingleton();
        }
        return instance;
    }
}
