package com.upb.programacion32020;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetallesPersonaActivity extends AppCompatActivity {

    ImageView imageViewPersona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_persona);

        imageViewPersona = findViewById(R.id.ivPersona);

        Intent intent = getIntent();
        if (intent.hasExtra("persona")) {
            Persona persona = (Persona) intent.getSerializableExtra("persona");
            imageViewPersona.setImageResource(persona.getImage());
        }
    }
}
