package com.upb.programacion32020;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    // Mis elementos
    Button loginButton;
    Switch adminSwitch;
    EditText editTextUsername;
    EditText editTextPassword;
    ProgressBar progressBar;
    TextView tvSolucionExamen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Seteamos el Layout a mostrarse para este activity
        setContentView(R.layout.activity_login);

        // Obtenemos los elementos del layout mostrandose ahora
        loginButton = findViewById(R.id.loginButton);
        adminSwitch = findViewById(R.id.switchAdmin);
        editTextUsername = findViewById(R.id.usernameEditText);
        editTextPassword = findViewById(R.id.passwordEditText);
        progressBar = findViewById(R.id.loadingProgressBar);
        tvSolucionExamen = findViewById(R.id.tvSolucionExamen);

        // Podemos escuchar a eventos de los elementos de la pantalla
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                // Abrir otro activity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("adminEnabled", adminSwitch.isChecked());

                Usuario user = new Usuario(editTextUsername.getText().toString(), editTextPassword.getText().toString());
                intent.putExtra("user", user);

                startActivity(intent);
            }
        });

        tvSolucionExamen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        adminSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    Log.d("TEST", "SWITCH -> TRUE");
                } else {
                    Log.d("TEST", "SWITCH -> FALSE");
                }
            }
        });

        editTextPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int action, KeyEvent keyEvent) {
                if (action == EditorInfo.IME_ACTION_SEARCH) {
                    Log.d("TEST", "KEYBOARD DONE");
                }
                return false;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
