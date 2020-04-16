package com.upb.programacion32020;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView tvHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        button = findViewById(R.id.btEditar);
        tvHeader = findViewById(R.id.tvHeader);

        Intent intent = getIntent();
        if (intent.hasExtra("adminEnabled")) {
            boolean adminEnabled = intent.getBooleanExtra("adminEnabled", false);
            button.setEnabled(adminEnabled);
        }

        if (intent.hasExtra("user")) {
            Usuario user = (Usuario) intent.getSerializableExtra("user");
            if (user != null) {
                tvHeader.setText("Bienvenido " + user.getUsername() + "!");
            }
        }
    }
}
