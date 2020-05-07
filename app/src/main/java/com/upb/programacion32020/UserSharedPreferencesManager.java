package com.upb.programacion32020;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class UserSharedPreferencesManager {

    private Context context;

    public UserSharedPreferencesManager(Context context) {
        this.context = context;
    }

    public void saveUser(Usuario usuario) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String usuarioString = "ERROR";

        // Tradicional
//        try {
//            JSONObject usuarioJson = new JSONObject();
//            usuarioJson.put("username", usuario.getUsername());
//            usuarioJson.put("password", usuario.getPassword());
//            usuarioString = usuarioJson.toString();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        // Simple
        Gson gson = new Gson();
        usuarioString = gson.toJson(usuario);

        editor.putString("usuario", usuarioString);
        editor.apply();

        Toast.makeText(context, "Usuario Almacenado Correctamente", Toast.LENGTH_SHORT).show();
    }

    public Usuario getUser() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        String usuarioString = sharedPreferences.getString("usuario", "{}");

        Usuario usuario;

        // Tradicional
//        try {
//            JSONObject jsonObject = new JSONObject(usuarioString);
//            usuario = new Usuario(
//                    jsonObject.getString("username"),
//                    jsonObject.getString("password")
//            );
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }

        // Simple
        Gson gson = new Gson();
        usuario = gson.fromJson(usuarioString, Usuario.class);

        return usuario;
    }

    public void updateUser(String newPassword) {
        Usuario usuario = getUser();
        usuario.setPassword(newPassword);
        saveUser(usuario);
    }

    public void deleteUser() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Usuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("usuario");
        editor.apply();
    }
}
