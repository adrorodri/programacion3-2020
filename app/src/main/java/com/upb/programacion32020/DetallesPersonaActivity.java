package com.upb.programacion32020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetallesPersonaActivity extends AppCompatActivity {

    ImageView imageViewPersona;
    Button buttonShare;
    Persona persona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_persona);

        imageViewPersona = findViewById(R.id.ivPersona);
        buttonShare = findViewById(R.id.btShare);

        Intent intent = getIntent();
        if (intent.hasExtra("persona")) {
            persona = (Persona) intent.getSerializableExtra("persona");
            imageViewPersona.setImageResource(persona.getImage());
        }

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Hey, comparte la aplicacion con " + persona.getNombre());
                startActivity(intent);
            }
        });
    }
}
