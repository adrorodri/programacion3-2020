package com.upb.programacion32020;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonEditar;
    Button buttonSalir;
    TextView tvHeader;
    Usuario user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        buttonEditar = findViewById(R.id.btEditar);
        buttonSalir = findViewById(R.id.btSalir);
        tvHeader = findViewById(R.id.tvHeader);

        Intent intent = getIntent();
        if (intent.hasExtra("adminEnabled")) {
            boolean adminEnabled = intent.getBooleanExtra("adminEnabled", false);
            buttonEditar.setEnabled(adminEnabled);
        }

        if (intent.hasExtra("user")) {
            user = (Usuario) intent.getSerializableExtra("user");
            if (user != null) {
                tvHeader.setText("Bienvenido " + user.getUsername() + "!");
            }
        }

        buttonSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("nombre", user.getUsername());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
